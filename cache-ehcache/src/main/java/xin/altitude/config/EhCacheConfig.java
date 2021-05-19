package xin.altitude.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author explore
 * @Date 2021/05/19 00:31
 **/
@Configuration
public class EhCacheConfig {
    @Bean
    public CacheManager cacheManager() {
        EhCacheCacheManager manager = new EhCacheCacheManager();
        return manager;
    }
}
