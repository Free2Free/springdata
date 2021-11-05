package xin.altitude.redis.cluster.caffeine.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xin.altitude.redis.cluster.caffeine.constants.CacheNameTimeConstant;

/**
 * @author explore
 * @since 2021/07/05 14:21
 **/
@Service
@Log4j2
public class CaffeineService {
    @Cacheable(cacheNames = CacheNameTimeConstant.CACHE_5SECS)
    public String getData(Integer id) {
        log.info("缓存数据" + id);
        return String.valueOf(id);
    }
    
    @Cacheable(cacheNames = CacheNameTimeConstant.CACHE_30SECS)
    public String getData2(Integer id) {
        log.info("缓存数据" + id);
        return String.valueOf(id);
    }
}
