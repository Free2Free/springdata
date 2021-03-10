package xin.altitude.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author explore
 */
@Service
//@CacheConfig(cacheNames = "userCache",keyGenerator = "customKeyGenerator")
public class EhCacheService {
    @Cacheable(cacheNames = "userCache")
    public String getData(int a) {
        System.out.println("第一次调用方法，第二次之后就直接从缓存取数据");
        return String.valueOf(a);
    }
}
