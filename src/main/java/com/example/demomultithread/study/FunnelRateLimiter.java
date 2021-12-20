package com.example.demomultithread.study;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * redis 接口限流--漏斗算法
 */
public class FunnelRateLimiter {

    static class Funnel {
        int capacity;  //漏斗容量
        float leakingRate;  //漏斗流水速率
        int leftQuota;  //漏斗剩余空间
        long leakingTs;  //上一次漏水时间

        public Funnel(int capacity, float leakingRate) { this.capacity = capacity;
            this.leakingRate = leakingRate; this.leftQuota = capacity;
            this.leakingTs = System.currentTimeMillis(); }

        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long deltaTs = nowTs - leakingTs;  //距离上一次漏水过去了多久
            int deltaQuota = (int) (deltaTs * leakingRate); //又可以腾出不少空间了
            if (deltaQuota < 0) { // 间隔时间太长，整数数字过大溢出
                this.leftQuota = capacity;
                this.leakingTs = nowTs; return;
            }
            if (deltaQuota < 1) { // 腾出空间太小，最小单位是 1
                return; }
            this.leftQuota += deltaQuota; this.leakingTs = nowTs;  //增加剩余空间
            if (this.leftQuota > this.capacity) {
                this.leftQuota = this.capacity; }
        }

        boolean watering(int quota) {
            makeSpace();
            if (this.leftQuota >= quota) {  // 判断剩余空间是否足够
                this.leftQuota -= quota;
                return true; }
            return false; }
    }

    private Map<String, Funnel> funnels = new HashMap<>();

    /**
     * capacity 漏斗容量
     * leaking_rate 漏嘴流水速率 quota/s
     */
    public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
        String key = String.format("%s:%s", userId, actionKey);
        Funnel funnel = funnels.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);

            funnels.put(key, funnel); }
        return funnel.watering(1);
        // 需要 1 个 quota
    }

    //测试
    public static void main(String[] args) {
        FunnelRateLimiter limiter = new FunnelRateLimiter();
        for(int i=0;i<200;i++) {
            System.out.println(limiter.isActionAllowed("limei", "123", 10, 1));
        }
    }

}

