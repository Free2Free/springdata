package xin.altitude.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xin.altitude.constants.CacheNameConstant;

/**
 * 操作自定义Redis数据库的数据
 *
 * @author explore
 */
@Service
// 从默认数据源中读取CacheManager
@CacheConfig(cacheNames = CacheNameConstant.VIEW, keyGenerator = "customKeyGenerator", cacheManager = "redisCacheManagerDb02")
public class Redis2Service {
    @Cacheable()
    public String getData(Integer a, Integer b) {
        System.out.println("第一次调用方法，第二次之后就直接从缓存取数据2");
        return String.format("%d,%d", a, b);
    }
}
