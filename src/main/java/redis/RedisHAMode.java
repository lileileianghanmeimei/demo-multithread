package redis;

public interface RedisHAMode {

    String MODE_STANDALONE = "standalone";
    String MODE_SENTINEL = "sentinel";
    String MODE_CLUSTER = "cluster";

}
