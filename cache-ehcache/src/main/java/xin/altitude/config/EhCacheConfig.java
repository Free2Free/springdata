package xin.altitude.config;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author explore
 * @Date 2021/03/19 15:13
 **/
@Configuration
public class EhCacheConfig {
    @Bean
    public EhCacheCacheManager ehCacheCacheManager() {
        return new EhCacheCacheManager();
    }
}
