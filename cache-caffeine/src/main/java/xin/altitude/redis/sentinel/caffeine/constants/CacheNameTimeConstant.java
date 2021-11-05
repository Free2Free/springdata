/*
 * Copyright (c) 2021. 流深数据
 */

package xin.altitude.redis.cluster.caffeine.constants;

/**
 * 定义标准CacheName名称列表
 * 不同名有不同的过期时间
 *
 * @Author explore
 * @Date 2021/05/12 16:34
 **/
public interface CacheNameTimeConstant {
    String CACHE_DEFAULT = "CACHE_DEFAULT";
    String CACHE_5SECS = "CACHE_5SECS";
    String CACHE_10SECS = "CACHE_10SECS";
    String CACHE_15SECS = "CACHE_15SECS";
    String CACHE_30SECS = "CACHE_30SECS";
    String CACHE_60SECS = "CACHE_60SECS";
    String CACHE_180SECS = "CACHE_180SECS";
}
