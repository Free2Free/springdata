package xin.altitude.redis.cluster.mutisourcecache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Author explore
 * @Date 2021/05/18 21:55
 **/
@Service
public class CacheService {
    
    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "users")
    public String getTime() {
        return String.valueOf(LocalDateTime.now());
    }
    
    @Cacheable(cacheManager = "ehCacheManager", cacheNames = "users")
    public String getTime2() {
        return String.valueOf(LocalDateTime.now());
    }
    
    @Cacheable(cacheManager = "redisCacheManager2", cacheNames = "users")
    public String getTime3() {
        return String.valueOf(LocalDateTime.now());
    }
}
