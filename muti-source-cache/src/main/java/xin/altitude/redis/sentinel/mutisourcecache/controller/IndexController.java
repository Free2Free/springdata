package xin.altitude.redis.cluster.mutisourcecache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.redis.cluster.mutisourcecache.service.CacheService;

/**
 * @Author explore
 * @Date 2021/05/18 21:53
 **/
@RestController
public class IndexController {
    @Autowired
    private CacheService cacheService;
    
    @GetMapping("/test")
    public String index() {
        return cacheService.getTime();
    }
    
    @GetMapping("/test2")
    public String index2() {
        return cacheService.getTime2();
    }
    
    @GetMapping("/test3")
    public String index3() {
        return cacheService.getTime3();
    }
}
