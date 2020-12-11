package xin.altitude.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author explore
 * @Date 2020/12/10 18:55
 **/
@RestController
public class IndexController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
//
//    @GetMapping("/")
//    public Object getData(){
////        mongoTemplate.fin
//    }

}
