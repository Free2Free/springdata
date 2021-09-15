package xin.altitude.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xin.altitude.constants.CacheNameTimeConstant;
import xin.altitude.domain.XUser;

import java.time.LocalDateTime;

/**
 * 自定义CacheName
 *
 * @author explore
 */
@Service
@Log4j2
@CacheConfig(cacheNames = CacheNameTimeConstant.CACHE_1MINS, keyGenerator = "customKeyGenerator")
public class EhCacheService {
    @Cacheable()
    public XUser getData() {
        log.info("缓存操作" + LocalDateTime.now());
        return XUser.builder().userId(1).userName("A").build();
    }
}