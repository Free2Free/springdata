package xin.altitude.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
//    @Autowired
//    private RedisConfig config;

    @Cacheable(value = "myname")
    public String getData(){
        System.out.println("第一次调用方法，第二次之后就直接从缓存取数据");
        return "ABCD";
    }
}
