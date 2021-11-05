package xin.altitude.redis.cluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.redis.cluster.domain.User;
import xin.altitude.redis.cluster.service.RedisService;

/**
 * @Author explore
 * @Date 2021/05/12 16:38
 **/
@RestController
public class IndexController {
    @Autowired
    private RedisService redisService;
    
    @GetMapping("/index")
    public String index() {
        return redisService.getData(1, 2);
    }
    
    @GetMapping("/user")
    public User user() {
        return redisService.getUser();
    }
    
    @GetMapping("/user2")
    public User user2() {
        return redisService.getUser2(10, "AAA");
    }
    
    @GetMapping("/user3")
    public User user3() {
        return redisService.getUser3(new User(3, "BBB"));
    }
    
    
    @GetMapping("/str")
    public String user4() {
        return redisService.getString();
    }
}
