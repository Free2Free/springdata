package xin.altitude.redis.cluster.constants;

/**
 * 定义标准CacheName名称列表
 * 不同名有不同的过期时间
 *
 * @Author explore
 * @Date 2021/05/12 16:34
 **/
public interface CacheNameTimeConstant {
    String DEFAULT = "DEFAULT";
    String CACHE_1MINS = "CACHE_1MINS";
    String CACHE_3MINS = "CACHE_3MINS";
    String CACHE_5MINS = "CACHE_5MINS";
    String CACHE_10MINS = "CACHE_10MINS";
    String CACHE_15MINS = "CACHE_15MINS";
    String CACHE_30MINS = "CACHE_30MINS";
    String CACHE_60MINS = "CACHE_60MINS";
    String CACHE_180MINS = "CACHE_180MINS";
    String CACHE_360MINS = "CACHE_360MINS";
}
