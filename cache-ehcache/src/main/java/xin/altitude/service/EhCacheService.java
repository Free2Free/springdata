package xin.altitude.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xin.altitude.constants.CacheNameTimeConstant;

import java.time.LocalDateTime;

/**
 * 自定义CacheName
 *
 * @author explore
 */
@Service
@CacheConfig(cacheNames = CacheNameTimeConstant.CACHE_1MINS, keyGenerator = "customKeyGenerator")
public class EhCacheService {
    @Cacheable()
    public LocalDateTime getData() {
        return LocalDateTime.now();
    }
}
