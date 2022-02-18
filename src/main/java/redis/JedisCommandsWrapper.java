package redis;

import redis.clients.jedis.*;
import redis.clients.jedis.params.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisCommandsWrapper {

    private Jedis jedis;

    private JedisCluster jedisCluster;

    public JedisCommandsWrapper(Jedis jedis) {
        this.jedis = jedis;
    }

    public JedisCommandsWrapper(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    public String set(String key, String value) {
        if (jedis != null) {
            return jedis.set(key, value);
        } else {
            return jedisCluster.set(key, value);
        }
    }

    public String set(String key, String value, SetParams params) {
        if (jedis != null) {
            return jedis.set(key, value, params);
        } else {
            return jedisCluster.set(key, value, params);
        }
    }

    public String get(String key) {
        if (jedis != null) {
            return jedis.get(key);
        } else {
            return jedisCluster.get(key);
        }
    }

    public Boolean exists(String key) {
        if (jedis != null) {
            return jedis.exists(key);
        } else {
            return jedisCluster.exists(key);
        }
    }

    public Long persist(String key) {
        if (jedis != null) {
            return jedis.persist(key);
        } else {
            return jedisCluster.persist(key);
        }
    }

    public String type(String key) {
        if (jedis != null) {
            return jedis.type(key);
        } else {
            return jedisCluster.type(key);
        }
    }

    public byte[] dump(String key) {
        if (jedis != null) {
            return jedis.dump(key);
        } else {
            return jedisCluster.dump(key);
        }
    }

    public String restore(String key, int ttl, byte[] serializedValue) {
        if (jedis != null) {
            return jedis.restore(key, ttl, serializedValue);
        } else {
            return jedisCluster.restore(key, ttl, serializedValue);
        }
    }

    public Long expire(String key, int seconds) {
        if (jedis != null) {
            return jedis.expire(key, seconds);
        } else {
            return jedisCluster.expire(key, seconds);
        }
    }

    public Long pexpire(String key, long milliseconds) {
        if (jedis != null) {
            return jedis.pexpire(key, milliseconds);
        } else {
            return jedisCluster.pexpire(key, milliseconds);
        }
    }

    public Long expireAt(String key, long unixTime) {
        if (jedis != null) {
            return jedis.expireAt(key, unixTime);
        } else {
            return jedisCluster.expireAt(key, unixTime);
        }
    }

    public Long pexpireAt(String key, long millisecondsTimestamp) {
        if (jedis != null) {
            return jedis.pexpireAt(key, millisecondsTimestamp);
        } else {
            return jedisCluster.pexpireAt(key, millisecondsTimestamp);
        }
    }

    public Long ttl(String key) {
        if (jedis != null) {
            return jedis.ttl(key);
        } else {
            return jedisCluster.ttl(key);
        }
    }

    public Long pttl(String key) {
        if (jedis != null) {
            return jedis.pttl(key);
        } else {
            return jedisCluster.pttl(key);
        }
    }

    public Long touch(String key) {
        if (jedis != null) {
            return jedis.touch(key);
        } else {
            return jedisCluster.touch(key);
        }
    }

    public Boolean setbit(String key, long offset, boolean value) {
        if (jedis != null) {
            return jedis.setbit(key, offset, value);
        } else {
            return jedisCluster.setbit(key, offset, value);
        }
    }

    public Boolean setbit(String key, long offset, String value) {
        if (jedis != null) {
            return jedis.setbit(key, offset, value);
        } else {
            return jedisCluster.setbit(key, offset, value);
        }
    }

    public Boolean getbit(String key, long offset) {
        if (jedis != null) {
            return jedis.getbit(key, offset);
        } else {
            return jedisCluster.getbit(key, offset);
        }
    }

    public Long setrange(String key, long offset, String value) {
        if (jedis != null) {
            return jedis.setrange(key, offset, value);
        } else {
            return jedisCluster.setrange(key, offset, value);
        }
    }

    public String getrange(String key, long startOffset, long endOffset) {
        if (jedis != null) {
            return jedis.getrange(key, startOffset, endOffset);
        } else {
            return jedisCluster.getrange(key, startOffset, endOffset);
        }
    }

    public String getSet(String key, String value) {
        if (jedis != null) {
            return jedis.getSet(key, value);
        } else {
            return jedisCluster.getSet(key, value);
        }
    }

    public Long setnx(String key, String value) {
        if (jedis != null) {
            return jedis.setnx(key, value);
        } else {
            return jedisCluster.setnx(key, value);
        }
    }

    public String setex(String key, int seconds, String value) {
        if (jedis != null) {
            return jedis.setex(key, seconds, value);
        } else {
            return jedisCluster.setex(key, seconds, value);
        }
    }

    public String psetex(String key, long milliseconds, String value) {
        if (jedis != null) {
            return jedis.psetex(key, milliseconds, value);
        } else {
            return jedisCluster.psetex(key, milliseconds, value);
        }
    }

    public Long decrBy(String key, long decrement) {
        if (jedis != null) {
            return jedis.decrBy(key, decrement);
        } else {
            return jedisCluster.decrBy(key, decrement);
        }
    }

    public Long decr(String key) {
        if (jedis != null) {
            return jedis.decr(key);
        } else {
            return jedisCluster.decr(key);
        }
    }

    public Long incrBy(String key, long increment) {
        if (jedis != null) {
            return jedis.incrBy(key, increment);
        } else {
            return jedisCluster.incrBy(key, increment);
        }
    }

    public Double incrByFloat(String key, double increment) {
        if (jedis != null) {
            return jedis.incrByFloat(key, increment);
        } else {
            return jedisCluster.incrByFloat(key, increment);
        }
    }

    public Long incr(String key) {
        if (jedis != null) {
            return jedis.incr(key);
        } else {
            return jedisCluster.incr(key);
        }
    }

    public Long append(String key, String value) {
        if (jedis != null) {
            return jedis.append(key, value);
        } else {
            return jedisCluster.append(key, value);
        }
    }

    public String substr(String key, int start, int end) {
        if (jedis != null) {
            return jedis.substr(key, start, end);
        } else {
            return jedisCluster.substr(key, start, end);
        }
    }

    public Long hset(String key, String field, String value) {
        if (jedis != null) {
            return jedis.hset(key, field, value);
        } else {
            return jedisCluster.hset(key, field, value);
        }
    }

    public Long hset(String key, Map<String, String> hash) {
        if (jedis != null) {
            return jedis.hset(key, hash);
        } else {
            return jedisCluster.hset(key, hash);
        }
    }

    public String hget(String key, String field) {
        if (jedis != null) {
            return jedis.hget(key, field);
        } else {
            return jedisCluster.hget(key, field);
        }
    }

    public Long hsetnx(String key, String field, String value) {
        if (jedis != null) {
            return jedis.hsetnx(key, field, value);
        } else {
            return jedisCluster.hsetnx(key, field, value);
        }
    }

    public String hmset(String key, Map<String, String> hash) {
        if (jedis != null) {
            return jedis.hmset(key, hash);
        } else {
            return jedisCluster.hmset(key, hash);
        }
    }

    public List<String> hmget(String key, String... fields) {
        if (jedis != null) {
            return jedis.hmget(key, fields);
        } else {
            return jedisCluster.hmget(key, fields);
        }
    }

    public Long hincrBy(String key, String field, long value) {
        if (jedis != null) {
            return jedis.hincrBy(key, field, value);
        } else {
            return jedisCluster.hincrBy(key, field, value);
        }
    }

    public Double hincrByFloat(String key, String field, double value) {
        if (jedis != null) {
            return jedis.hincrByFloat(key, field, value);
        } else {
            return jedisCluster.hincrByFloat(key, field, value);
        }
    }

    public Boolean hexists(String key, String field) {
        if (jedis != null) {
            return jedis.hexists(key, field);
        } else {
            return jedisCluster.hexists(key, field);
        }
    }

    public Long hdel(String key, String... field) {
        if (jedis != null) {
            return jedis.hdel(key, field);
        } else {
            return jedisCluster.hdel(key, field);
        }
    }

    public Long hlen(String key) {
        if (jedis != null) {
            return jedis.hlen(key);
        } else {
            return jedisCluster.hlen(key);
        }
    }

    public Set<String> hkeys(String key) {
        if (jedis != null) {
            return jedis.hkeys(key);
        } else {
            return jedisCluster.hkeys(key);
        }
    }

    public List<String> hvals(String key) {
        if (jedis != null) {
            return jedis.hvals(key);
        } else {
            return jedisCluster.hvals(key);
        }
    }

    public Map<String, String> hgetAll(String key) {
        if (jedis != null) {
            return jedis.hgetAll(key);
        } else {
            return jedisCluster.hgetAll(key);
        }
    }

    public Long rpush(String key, String... string) {
        if (jedis != null) {
            return jedis.rpush(key, string);
        } else {
            return jedisCluster.rpush(key, string);
        }
    }

    public Long lpush(String key, String... string) {
        if (jedis != null) {
            return jedis.lpush(key, string);
        } else {
            return jedisCluster.lpush(key, string);
        }
    }

    public Long llen(String key) {
        if (jedis != null) {
            return jedis.llen(key);
        } else {
            return jedisCluster.llen(key);
        }
    }

    public List<String> lrange(String key, long start, long stop) {
        if (jedis != null) {
            return jedis.lrange(key, start, stop);
        } else {
            return jedisCluster.lrange(key, start, stop);
        }
    }

    public String ltrim(String key, long start, long stop) {
        if (jedis != null) {
            return jedis.ltrim(key, start, stop);
        } else {
            return jedisCluster.ltrim(key, start, stop);
        }
    }

    public String lindex(String key, long index) {
        if (jedis != null) {
            return jedis.lindex(key, index);
        } else {
            return jedisCluster.lindex(key, index);
        }
    }

    public String lset(String key, long index, String value) {
        if (jedis != null) {
            return jedis.lset(key, index, value);
        } else {
            return jedisCluster.lset(key, index, value);
        }
    }

    public Long lrem(String key, long count, String value) {
        if (jedis != null) {
            return jedis.lrem(key, count, value);
        } else {
            return jedisCluster.lrem(key, count, value);
        }
    }

    public String lpop(String key) {
        if (jedis != null) {
            return jedis.lpop(key);
        } else {
            return jedisCluster.lpop(key);
        }
    }

    public List<String> lpop(String key, int count) {
        if (jedis != null) {
            return jedis.lpop(key, count);
        } else {
            return jedisCluster.lpop(key, count);
        }
    }

    public Long lpos(String key, String element) {
        if (jedis != null) {
            return jedis.lpos(key, element);
        } else {
            return jedisCluster.lpos(key, element);
        }
    }

    public Long lpos(String key, String element, LPosParams params) {
        if (jedis != null) {
            return jedis.lpos(key, element, params);
        } else {
            return jedisCluster.lpos(key, element, params);
        }
    }

    public List<Long> lpos(String key, String element, LPosParams params, long count) {
        if (jedis != null) {
            return jedis.lpos(key, element, params, count);
        } else {
            return jedisCluster.lpos(key, element, params, count);
        }
    }

    public String rpop(String key) {
        if (jedis != null) {
            return jedis.rpop(key);
        } else {
            return jedisCluster.rpop(key);
        }
    }

    public List<String> rpop(String key, int count) {
        if (jedis != null) {
            return jedis.rpop(key, count);
        } else {
            return jedisCluster.rpop(key, count);
        }
    }

    public Long sadd(String key, String... member) {
        if (jedis != null) {
            return jedis.sadd(key, member);
        } else {
            return jedisCluster.sadd(key, member);
        }
    }

    public Set<String> smembers(String key) {
        if (jedis != null) {
            return jedis.smembers(key);
        } else {
            return jedisCluster.smembers(key);
        }
    }

    public Long srem(String key, String... member) {
        if (jedis != null) {
            return jedis.srem(key, member);
        } else {
            return jedisCluster.srem(key, member);
        }
    }

    public String spop(String key) {
        if (jedis != null) {
            return jedis.spop(key);
        } else {
            return jedisCluster.spop(key);
        }
    }

    public Set<String> spop(String key, long count) {
        if (jedis != null) {
            return jedis.spop(key, count);
        } else {
            return jedisCluster.spop(key, count);
        }
    }

    public Long scard(String key) {
        if (jedis != null) {
            return jedis.scard(key);
        } else {
            return jedisCluster.scard(key);
        }
    }

    public Boolean sismember(String key, String member) {
        if (jedis != null) {
            return jedis.sismember(key, member);
        } else {
            return jedisCluster.sismember(key, member);
        }
    }

    public List<Boolean> smismember(String key, String... members) {
        if (jedis != null) {
            return jedis.smismember(key, members);
        } else {
            return jedisCluster.smismember(key, members);
        }
    }

    public String srandmember(String key) {
        if (jedis != null) {
            return jedis.srandmember(key);
        } else {
            return jedisCluster.srandmember(key);
        }
    }

    public List<String> srandmember(String key, int count) {
        if (jedis != null) {
            return jedis.srandmember(key, count);
        } else {
            return jedisCluster.srandmember(key, count);
        }
    }

    public Long strlen(String key) {
        if (jedis != null) {
            return jedis.strlen(key);
        } else {
            return jedisCluster.strlen(key);
        }
    }

    public Long zadd(String key, double score, String member) {
        if (jedis != null) {
            return jedis.zadd(key, score, member);
        } else {
            return jedisCluster.zadd(key, score, member);
        }
    }

    public Long zadd(String key, double score, String member, ZAddParams params) {
        if (jedis != null) {
            return jedis.zadd(key, score, member, params);
        } else {
            return jedisCluster.zadd(key, score, member, params);
        }
    }

    public Long zadd(String key, Map<String, Double> scoreMembers) {
        if (jedis != null) {
            return jedis.zadd(key, scoreMembers);
        } else {
            return jedisCluster.zadd(key, scoreMembers);
        }
    }

    public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params) {
        if (jedis != null) {
            return jedis.zadd(key, scoreMembers, params);
        } else {
            return jedisCluster.zadd(key, scoreMembers, params);
        }
    }

    public Set<String> zrange(String key, long start, long stop) {
        if (jedis != null) {
            return jedis.zrange(key, start, stop);
        } else {
            return jedisCluster.zrange(key, start, stop);
        }
    }

    public Long zrem(String key, String... members) {
        if (jedis != null) {
            return jedis.zrem(key, members);
        } else {
            return jedisCluster.zrem(key, members);
        }
    }

    public Double zincrby(String key, double increment, String member) {
        if (jedis != null) {
            return jedis.zincrby(key, increment, member);
        } else {
            return jedisCluster.zincrby(key, increment, member);
        }
    }

    public Double zincrby(String key, double increment, String member, ZIncrByParams params) {
        if (jedis != null) {
            return jedis.zincrby(key, increment, member, params);
        } else {
            return jedisCluster.zincrby(key, increment, member, params);
        }
    }

    public Long zrank(String key, String member) {
        if (jedis != null) {
            return jedis.zrank(key, member);
        } else {
            return jedisCluster.zrank(key, member);
        }
    }

    public Long zrevrank(String key, String member) {
        if (jedis != null) {
            return jedis.zrevrank(key, member);
        } else {
            return jedisCluster.zrevrank(key, member);
        }
    }

    public Set<String> zrevrange(String key, long start, long stop) {
        if (jedis != null) {
            return jedis.zrevrange(key, start, stop);
        } else {
            return jedisCluster.zrevrange(key, start, stop);
        }
    }

    public Set<Tuple> zrangeWithScores(String key, long start, long stop) {
        if (jedis != null) {
            return jedis.zrangeWithScores(key, start, stop);
        } else {
            return jedisCluster.zrangeWithScores(key, start, stop);
        }
    }

    public Set<Tuple> zrevrangeWithScores(String key, long start, long stop) {
        if (jedis != null) {
            return jedis.zrevrangeWithScores(key, start, stop);
        } else {
            return jedisCluster.zrevrangeWithScores(key, start, stop);
        }
    }

    public Long zcard(String key) {
        if (jedis != null) {
            return jedis.zcard(key);
        } else {
            return jedisCluster.zcard(key);
        }
    }

    public Double zscore(String key, String member) {
        if (jedis != null) {
            return jedis.zscore(key, member);
        } else {
            return jedisCluster.zscore(key, member);
        }
    }

    public List<Double> zmscore(String key, String... members) {
        if (jedis != null) {
            return jedis.zmscore(key, members);
        } else {
            return jedisCluster.zmscore(key, members);
        }
    }

    public Tuple zpopmax(String key) {
        if (jedis != null) {
            return jedis.zpopmax(key);
        } else {
            return jedisCluster.zpopmax(key);
        }
    }

    public Set<Tuple> zpopmax(String key, int count) {
        if (jedis != null) {
            return jedis.zpopmax(key, count);
        } else {
            return jedisCluster.zpopmax(key, count);
        }
    }

    public Tuple zpopmin(String key) {
        if (jedis != null) {
            return jedis.zpopmin(key);
        } else {
            return jedisCluster.zpopmin(key);
        }
    }

    public Set<Tuple> zpopmin(String key, int count) {
        if (jedis != null) {
            return jedis.zpopmin(key, count);
        } else {
            return jedisCluster.zpopmin(key, count);
        }
    }

    public List<String> sort(String key) {
        if (jedis != null) {
            return jedis.sort(key);
        } else {
            return jedisCluster.sort(key);
        }
    }

    public List<String> sort(String key, SortingParams sortingParameters) {
        if (jedis != null) {
            return jedis.sort(key, sortingParameters);
        } else {
            return jedisCluster.sort(key, sortingParameters);
        }
    }

    public Long zcount(String key, double min, double max) {
        if (jedis != null) {
            return jedis.zcount(key, min, max);
        } else {
            return jedisCluster.zcount(key, min, max);
        }
    }

    public Long zcount(String key, String min, String max) {
        if (jedis != null) {
            return jedis.zcount(key, min, max);
        } else {
            return jedisCluster.zcount(key, min, max);
        }
    }

    public Set<String> zrangeByScore(String key, double min, double max) {
        if (jedis != null) {
            return jedis.zrangeByScore(key, min, max);
        } else {
            return jedisCluster.zrangeByScore(key, min, max);
        }
    }

    public Set<String> zrangeByScore(String key, String min, String max) {
        if (jedis != null) {
            return jedis.zrangeByScore(key, min, max);
        } else {
            return jedisCluster.zrangeByScore(key, min, max);
        }
    }

    public Set<String> zrevrangeByScore(String key, double max, double min) {
        if (jedis != null) {
            return jedis.zrevrangeByScore(key, max, min);
        } else {
            return jedisCluster.zrevrangeByScore(key, max, min);
        }
    }

    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        if (jedis != null) {
            return jedis.zrangeByScore(key, min, max, offset, count);
        } else {
            return jedisCluster.zrangeByScore(key, min, max, offset, count);
        }
    }

    public Set<String> zrevrangeByScore(String key, String max, String min) {
        if (jedis != null) {
            return jedis.zrevrangeByScore(key, max, min);
        } else {
            return jedisCluster.zrevrangeByScore(key, max, min);
        }
    }

    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
        if (jedis != null) {
            return jedis.zrangeByScore(key, min, max, offset, count);
        } else {
            return jedisCluster.zrangeByScore(key, min, max, offset, count);
        }
    }

    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        if (jedis != null) {
            return jedis.zrevrangeByScore(key, max, min, offset, count);
        } else {
            return jedisCluster.zrevrangeByScore(key, max, min, offset, count);
        }
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
        if (jedis != null) {
            return jedis.zrangeByScoreWithScores(key, min, max);
        } else {
            return jedisCluster.zrangeByScoreWithScores(key, min, max);
        }
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
        if (jedis != null) {
            return jedis.zrevrangeByScoreWithScores(key, max, min);
        } else {
            return jedisCluster.zrevrangeByScoreWithScores(key, max, min);
        }
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        if (jedis != null) {
            return jedis.zrangeByScoreWithScores(key, min, max, offset, count);
        } else {
            return jedisCluster.zrangeByScoreWithScores(key, min, max, offset, count);
        }
    }

    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {
        if (jedis != null) {
            return jedis.zrevrangeByScore(key, max, min, offset, count);
        } else {
            return jedisCluster.zrevrangeByScore(key, max, min, offset, count);
        }
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
        if (jedis != null) {
            return jedis.zrangeByScoreWithScores(key, min, max);
        } else {
            return jedisCluster.zrangeByScoreWithScores(key, min, max);
        }
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {
        if (jedis != null) {
            return jedis.zrevrangeByScoreWithScores(key, max, min);
        } else {
            return jedisCluster.zrevrangeByScoreWithScores(key, max, min);
        }
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
        if (jedis != null) {
            return jedis.zrangeByScoreWithScores(key, min, max, offset, count);
        } else {
            return jedisCluster.zrangeByScoreWithScores(key, min, max, offset, count);
        }
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
        if (jedis != null) {
            return jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        } else {
            return jedisCluster.zrevrangeByScoreWithScores(key, max, min, offset, count);
        }
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count) {
        if (jedis != null) {
            return jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        } else {
            return jedisCluster.zrevrangeByScoreWithScores(key, max, min, offset, count);
        }
    }

    public Long zremrangeByRank(String key, long start, long stop) {
        if (jedis != null) {
            return jedis.zremrangeByRank(key, start, stop);
        } else {
            return jedisCluster.zremrangeByRank(key, start, stop);
        }
    }

    public Long zremrangeByScore(String key, double min, double max) {
        if (jedis != null) {
            return jedis.zremrangeByScore(key, min, max);
        } else {
            return jedisCluster.zremrangeByScore(key, min, max);
        }
    }

    public Long zremrangeByScore(String key, String min, String max) {
        if (jedis != null) {
            return jedis.zremrangeByScore(key, min, max);
        } else {
            return jedisCluster.zremrangeByScore(key, min, max);
        }
    }

    public Long zlexcount(String key, String min, String max) {
        if (jedis != null) {
            return jedis.zlexcount(key, min, max);
        } else {
            return jedisCluster.zlexcount(key, min, max);
        }
    }

    public Set<String> zrangeByLex(String key, String min, String max) {
        if (jedis != null) {
            return jedis.zrangeByLex(key, min, max);
        } else {
            return jedisCluster.zrangeByLex(key, min, max);
        }
    }

    public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
        if (jedis != null) {
            return jedis.zrangeByLex(key, min, max, offset, count);
        } else {
            return jedisCluster.zrangeByLex(key, min, max, offset, count);
        }
    }

    public Set<String> zrevrangeByLex(String key, String max, String min) {
        if (jedis != null) {
            return jedis.zrevrangeByLex(key, max, min);
        } else {
            return jedisCluster.zrevrangeByLex(key, max, min);
        }
    }

    public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
        if (jedis != null) {
            return jedis.zrevrangeByLex(key, max, min, offset, count);
        } else {
            return jedisCluster.zrevrangeByLex(key, max, min, offset, count);
        }
    }

    public Long zremrangeByLex(String key, String min, String max) {
        if (jedis != null) {
            return jedis.zremrangeByLex(key, min, max);
        } else {
            return jedisCluster.zremrangeByLex(key, min, max);
        }
    }

    public Long linsert(String key, ListPosition where, String pivot, String value) {
        if (jedis != null) {
            return jedis.linsert(key, where, pivot, value);
        } else {
            return jedisCluster.linsert(key, where, pivot, value);
        }
    }

    public Long lpushx(String key, String... string) {
        if (jedis != null) {
            return jedis.lpushx(key, string);
        } else {
            return jedisCluster.lpushx(key, string);
        }
    }

    public Long rpushx(String key, String... string) {
        if (jedis != null) {
            return jedis.rpushx(key, string);
        } else {
            return jedisCluster.rpushx(key, string);
        }
    }

    public List<String> blpop(int timeout, String key) {
        if (jedis != null) {
            return jedis.blpop(timeout, key);
        } else {
            return jedisCluster.blpop(timeout, key);
        }
    }

    public List<String> brpop(int timeout, String key) {
        if (jedis != null) {
            return jedis.brpop(timeout, key);
        } else {
            return jedisCluster.brpop(timeout, key);
        }
    }

    public Long del(String key) {
        if (jedis != null) {
            return jedis.del(key);
        } else {
            return jedisCluster.del(key);
        }
    }

    public Long unlink(String key) {
        if (jedis != null) {
            return jedis.unlink(key);
        } else {
            return jedisCluster.unlink(key);
        }
    }

    public String echo(String string) {
        if (jedis != null) {
            return jedis.echo(string);
        } else {
            return jedisCluster.echo(string);
        }
    }

    public Long bitcount(String key) {
        if (jedis != null) {
            return jedis.bitcount(key);
        } else {
            return jedisCluster.bitcount(key);
        }
    }

    public Long bitcount(String key, long start, long end) {
        if (jedis != null) {
            return jedis.bitcount(key, start, end);
        } else {
            return jedisCluster.bitcount(key, start, end);
        }
    }

    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) {
        if (jedis != null) {
            return jedis.hscan(key, cursor);
        } else {
            return jedisCluster.hscan(key, cursor);
        }
    }

    public ScanResult<String> sscan(String key, String cursor) {
        if (jedis != null) {
            return jedis.sscan(key, cursor);
        } else {
            return jedisCluster.sscan(key, cursor);
        }
    }

    public ScanResult<Tuple> zscan(String key, String cursor) {
        if (jedis != null) {
            return jedis.zscan(key, cursor);
        } else {
            return jedisCluster.zscan(key, cursor);
        }
    }

    public Long pfadd(String key, String... elements) {
        if (jedis != null) {
            return jedis.pfadd(key, elements);
        } else {
            return jedisCluster.pfadd(key, elements);
        }
    }

    public long pfcount(String key) {
        if (jedis != null) {
            return jedis.pfcount(key);
        } else {
            return jedisCluster.pfcount(key);
        }
    }

    public Long geoadd(String key, double longitude, double latitude, String member) {
        if (jedis != null) {
            return jedis.geoadd(key, longitude, latitude, member);
        } else {
            return jedisCluster.geoadd(key, longitude, latitude, member);
        }
    }

    public Long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap) {
        if (jedis != null) {
            return jedis.geoadd(key, memberCoordinateMap);
        } else {
            return jedisCluster.geoadd(key, memberCoordinateMap);
        }
    }

    public Double geodist(String key, String member1, String member2) {
        if (jedis != null) {
            return jedis.geodist(key, member1, member2);
        } else {
            return jedisCluster.geodist(key, member1, member2);
        }
    }

    public Double geodist(String key, String member1, String member2, GeoUnit unit) {
        if (jedis != null) {
            return jedis.geodist(key, member1, member2, unit);
        } else {
            return jedisCluster.geodist(key, member1, member2, unit);
        }
    }

    public List<String> geohash(String key, String... members) {
        if (jedis != null) {
            return jedis.geohash(key, members);
        } else {
            return jedisCluster.geohash(key, members);
        }
    }

    public List<GeoCoordinate> geopos(String key, String... members) {
        if (jedis != null) {
            return jedis.geopos(key, members);
        } else {
            return jedisCluster.geopos(key, members);
        }
    }

    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit) {
        if (jedis != null) {
            return jedis.georadius(key, longitude, latitude, radius, unit);
        } else {
            return jedisCluster.georadius(key, longitude, latitude, radius, unit);
        }
    }

    public List<GeoRadiusResponse> georadiusReadonly(String key, double longitude, double latitude, double radius, GeoUnit unit) {
        if (jedis != null) {
            return jedis.georadiusReadonly(key, longitude, latitude, radius, unit);
        } else {
            return jedisCluster.georadiusReadonly(key, longitude, latitude, radius, unit);
        }
    }

    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        if (jedis != null) {
            return jedis.georadius(key, longitude, latitude, radius, unit, param);
        } else {
            return jedisCluster.georadius(key, longitude, latitude, radius, unit, param);
        }
    }

    public List<GeoRadiusResponse> georadiusReadonly(String key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        if (jedis != null) {
            return jedis.georadiusReadonly(key, longitude, latitude, radius, unit, param);
        } else {
            return jedisCluster.georadiusReadonly(key, longitude, latitude, radius, unit, param);
        }
    }

    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit) {
        if (jedis != null) {
            return jedis.georadiusByMember(key, member, radius, unit);
        } else {
            return jedisCluster.georadiusByMember(key, member, radius, unit);
        }
    }

    public List<GeoRadiusResponse> georadiusByMemberReadonly(String key, String member, double radius, GeoUnit unit) {
        if (jedis != null) {
            return jedis.georadiusByMemberReadonly(key, member, radius, unit);
        } else {
            return jedisCluster.georadiusByMemberReadonly(key, member, radius, unit);
        }
    }

    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit, GeoRadiusParam param) {
        if (jedis != null) {
            return jedis.georadiusByMember(key, member, radius, unit, param);
        } else {
            return jedisCluster.georadiusByMember(key, member, radius, unit, param);
        }
    }

    public List<GeoRadiusResponse> georadiusByMemberReadonly(String key, String member, double radius, GeoUnit unit, GeoRadiusParam param) {
        if (jedis != null) {
            return jedis.georadiusByMemberReadonly(key, member, radius, unit, param);
        } else {
            return jedisCluster.georadiusByMemberReadonly(key, member, radius, unit, param);
        }
    }

    public List<Long> bitfield(String key, String... arguments) {
        if (jedis != null) {
            return jedis.bitfield(key, arguments);
        } else {
            return jedisCluster.bitfield(key, arguments);
        }
    }

    public List<Long> bitfieldReadonly(String key, String... arguments) {
        if (jedis != null) {
            return jedis.bitfieldReadonly(key, arguments);
        } else {
            return jedisCluster.bitfieldReadonly(key, arguments);
        }
    }

}
