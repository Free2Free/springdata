package xin.altitude.redis.cluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.redis.cluster.domain.XUser;
import xin.altitude.redis.cluster.service.EhCacheService;

/**
 * @Author explore
 * @Date 2021/03/05 14:58
 **/
@RestController
public class IndexController {
    @Autowired
    private EhCacheService ehCacheService;
    
    @GetMapping("/index")
    public XUser index() {
        return ehCacheService.getData();
    }
}
