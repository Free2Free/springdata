package xin.altitude.caffeine.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xin.altitude.caffeine.constants.CacheNameTimeConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author explore
 * @since 2021/07/05 14:18
 **/
@Configuration
public class CaffeineConfig {
    @Bean
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caches = new ArrayList<>();
        caches.add(new CaffeineCache(CacheNameTimeConstant.CACHE_5SECS,
                Caffeine.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build()));
        caches.add(new CaffeineCache(CacheNameTimeConstant.CACHE_10SECS,
                Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).build()));
        caches.add(new CaffeineCache(CacheNameTimeConstant.CACHE_30SECS,
                Caffeine.newBuilder().expireAfterWrite(30, TimeUnit.SECONDS).build()));
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
