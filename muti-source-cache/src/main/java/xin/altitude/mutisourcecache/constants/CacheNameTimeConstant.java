package xin.altitude.mutisourcecache.constants;

import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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
    
    
    /**
     * 不同CacheName配置
     */
    static Map<String, RedisCacheConfiguration> initialCacheConfigurations(RedisCacheConfiguration config) {
        Map<String, RedisCacheConfiguration> hashMap = new HashMap<>();
        hashMap.put(CacheNameTimeConstant.DEFAULT, config.entryTtl(Duration.ofDays(1)));
        hashMap.put(CacheNameTimeConstant.CACHE_1MINS, config.entryTtl(Duration.ofMinutes(1)));
        hashMap.put(CacheNameTimeConstant.CACHE_3MINS, config.entryTtl(Duration.ofMinutes(3)));
        hashMap.put(CacheNameTimeConstant.CACHE_5MINS, config.entryTtl(Duration.ofMinutes(5)));
        hashMap.put(CacheNameTimeConstant.CACHE_10MINS, config.entryTtl(Duration.ofMinutes(10)));
        hashMap.put(CacheNameTimeConstant.CACHE_15MINS, config.entryTtl(Duration.ofMinutes(15)));
        hashMap.put(CacheNameTimeConstant.CACHE_30MINS, config.entryTtl(Duration.ofMinutes(30)));
        return hashMap;
    }
    
}
