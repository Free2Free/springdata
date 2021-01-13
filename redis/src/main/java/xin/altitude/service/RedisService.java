package xin.altitude.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
//    private final String cacheName = this.getClass().getName().replaceAll(".","");

    @Cacheable(cacheNames = "myKeyGenerator")
    public String getData(){
        System.out.println("第一次调用方法，第二次之后就直接从缓存取数据");
        return "ABCD";
    }
}
