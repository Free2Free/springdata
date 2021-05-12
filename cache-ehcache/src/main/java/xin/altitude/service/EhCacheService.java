package xin.altitude.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 自定义CacheName
 *
 * @author explore
 */
@Service
@CacheConfig(cacheNames = "userCache", keyGenerator = "customKeyGenerator")
public class EhCacheService {
    @Cacheable()
    public String getData(int a) {
        System.out.println("第一次调用方法，第二次之后就直接从缓存取数据");
        return String.valueOf(a);
    }
}
