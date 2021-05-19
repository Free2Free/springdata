package xin.altitude.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 自定义CacheName
 *
 * @author explore
 */
@Service
@CacheConfig(cacheNames = "userCache", keyGenerator = "customKeyGenerator")
public class EhCacheService {
    @Cacheable()
    public String getData() {
        return String.valueOf(LocalDateTime.now());
    }
}
