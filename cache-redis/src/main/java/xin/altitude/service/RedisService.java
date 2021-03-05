package xin.altitude.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Condition;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@CacheConfig(cacheNames = "VIEW",keyGenerator = "customKeyGenerator")
public class RedisService {
    @Cacheable(unless = "#result==null")
    public String getData(Integer a, String b, Model model){
        System.out.println("第一次调用方法，第二次之后就直接从缓存取数据");
        return null;
    }
}
