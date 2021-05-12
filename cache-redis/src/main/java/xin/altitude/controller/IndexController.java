package xin.altitude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.service.Redis2Service;
import xin.altitude.service.RedisService;

/**
 * @Author explore
 * @Date 2021/05/12 16:38
 **/
@RestController
public class IndexController {
    @Autowired
    private RedisService redisService;
    
    @Autowired
    private Redis2Service redis2Service;
    
    @GetMapping("/index")
    public String index() {
        return redisService.getData(1, 2);
    }
    
    @GetMapping("/index2")
    public String index2() {
        return redis2Service.getData(1, 3);
    }
}
