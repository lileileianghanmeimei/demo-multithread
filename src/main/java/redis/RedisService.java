package redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import redis.clients.jedis.*;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class RedisService {

    @Value("${redis.haMode:standalone}")
    private String haMode = "standalone";

    @Value("${redis.enableSsl:false}")
    private boolean enableSsl;

    @Value("${redis.host:}")
    private String host;
    @Value("${redis.port:0}")
    private Integer port;
    @Value("${redis.password:}")
    private String password;
    @Value("${redis.database:0}")
    private Integer database;

    @Value("${redis.sentinel.nodes:}")
    private String sentinelNodes;
    @Value("${redis.sentinel.master:}")
    private String sentinelMaster;
    @Value("${redis.sentinel.password:}")
    private String sentinelPassword;

    @Value("${redis.cluster.nodes:}")
    private String clusterNodes;
    @Value("${redis.cluster.password:}")
    private String clusterPassword;

    @Value("${redis.poolConfig.maxIdle}")
    private Integer maxIdle;
    @Value("${redis.poolConfig.maxTotal:50}")
    private Integer maxTotal;

    private JedisPoolAbstract jedisPool;

    private JedisCluster jedisCluster;

    public void setHaMode(String haMode) {
        this.haMode = haMode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public void setSentinelMaster(String sentinelMaster) {
        this.sentinelMaster = sentinelMaster;
    }

    public void setSentinelPassword(String sentinelPassword) {
        this.sentinelPassword = sentinelPassword;
    }

    public void setSentinelNodes(String sentinelNodes) {
        this.sentinelNodes = sentinelNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public void setClusterPassword(String clusterPassword) {
        this.clusterPassword = clusterPassword;
    }

    public void setEnableSsl(boolean enableSsl) {
        this.enableSsl = enableSsl;
    }

    public RedisService() {
    }

    public RedisService(String host, String password, Integer port, Integer maxIdle) {
        this.host = host;
        this.password = password;
        this.port = port;
        this.maxIdle = maxIdle;
    }

    public RedisService(String host, String password, Integer port, Integer maxIdle, Integer maxTotal) {
        this(host, password, port, maxIdle);
        this.maxTotal = maxTotal;
    }

    public RedisService(String host, String password, Integer port, Integer maxIdle, Integer maxTotal, boolean enableSsl) {
        this(host, password, port, maxIdle, maxTotal);
        this.enableSsl = enableSsl;
    }

    public RedisService(String sentinelNodes, String sentinelMaster, String sentinelPassword) {
        this.haMode = RedisHAMode.MODE_SENTINEL;
        this.sentinelNodes = sentinelNodes;
        this.sentinelMaster = sentinelMaster;
        this.sentinelPassword = sentinelPassword;
    }

    public RedisService(String clusterNodes, String clusterPassword) {
        this.haMode = RedisHAMode.MODE_CLUSTER;
        this.clusterNodes = clusterNodes;
        this.clusterPassword = clusterPassword;
    }

    @PostConstruct()
    public void init() {
        log.info("=== initializing RedisService with HA Mode {}.", haMode);

        if (!RedisHAMode.MODE_STANDALONE.equalsIgnoreCase(haMode)
                && !RedisHAMode.MODE_SENTINEL.equalsIgnoreCase(haMode)
                && !RedisHAMode.MODE_CLUSTER.equalsIgnoreCase(haMode)) {
            throw new IllegalStateException(String.format("not supporting HA mode %s", haMode));
        }

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMinIdle(10);
        poolConfig.setMaxWaitMillis(2000);
        poolConfig.setTestOnReturn(true);

        if (RedisHAMode.MODE_STANDALONE.equalsIgnoreCase(haMode)) {
            if (!StringUtils.hasText(host)) {
                throw new IllegalStateException("Missing value of host.");
            }
            if (port == 0) {
                throw new IllegalStateException("Missing value of port.");
            }

            jedisPool = new JedisPool(
                    poolConfig,
                    host,
                    port,
                    Protocol.DEFAULT_TIMEOUT,
                    StringUtils.isEmpty(password) ? null : password,
                    database, enableSsl);

        } else if (RedisHAMode.MODE_SENTINEL.equalsIgnoreCase(haMode)) {
            if (!StringUtils.hasText(sentinelNodes)) {
                throw new IllegalStateException("Missing value of sentinelNodes.");
            }
            if (!StringUtils.hasText(sentinelMaster)) {
                throw new IllegalStateException("Missing value of sentinelMaster.");
            }
            Set<String> sentinels = Stream.of(sentinelNodes.split(","))
                    .collect(Collectors.toSet());

            jedisPool = new JedisSentinelPool(
                    sentinelMaster,
                    sentinels,
                    poolConfig,
                    Protocol.DEFAULT_TIMEOUT,
                    StringUtils.isEmpty(sentinelPassword) ? null : sentinelPassword,
                    database);

        } else if (RedisHAMode.MODE_CLUSTER.equalsIgnoreCase(haMode)) {
            // 2.9.x的Jedis和JedisCluster共同实现了JedisCommands接口，但是在3.x版本后，JedisCluster改成实现JedisClusterCommands接口。

            if (!StringUtils.hasText(clusterNodes)) {
                throw new IllegalStateException("Missing value of clusterNodes.");
            }

            Set<HostAndPort> nodes =
                    Stream.of(clusterNodes.split(",")).map(nodeStr -> {
                        String[] array = nodeStr.split(":");
                        return new HostAndPort(array[0], Integer.parseInt(array[1]));
                    }).collect(Collectors.toSet());

            jedisCluster = new JedisCluster(
                    nodes,
                    1000,
                    1000,
                    2,
                    StringUtils.isEmpty(clusterPassword) ? null : clusterPassword,
                    poolConfig);
        }
    }

    // 如果要支持Cluster，需要修改的引用处太多，暂时先支持Standalone和Sentinel。
//    public void withRedis(Consumer<JedisCommandsWrapper> consumer) {
//        JedisCommandsWrapper commandsWrapper;
//        if (HA_MODE_STANDALONE.equalsIgnoreCase(haMode) || HA_MODE_SENTINEL.equalsIgnoreCase(haMode)) {
//            Jedis jedis = null;
//            try {
//                jedis = jedisPool.getResource();
//                commandsWrapper = new JedisCommandsWrapper(jedis);
//                consumer.accept(commandsWrapper);
//            } catch (Exception e) {
//                log.error("exception occurred while accessing redis.", e);
//            } finally {
//                if (jedis != null) {
//                    jedis.close();
//                }
//            }
//        } else if (HA_MODE_CLUSTER.equalsIgnoreCase(haMode)) {
//            try {
//                commandsWrapper = new JedisCommandsWrapper(jedisCluster);
//                consumer.accept(commandsWrapper);
//            } catch (Exception e) {
//                log.error("exception occurred while accessing redis cluster.", e);
//            }
//        }
//    }

    public void withRedis(Consumer<Jedis> consumer) {
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            consumer.accept(jedis);
        } catch (Exception e) {
            log.error("exception occurred while accessing redis.", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

}
