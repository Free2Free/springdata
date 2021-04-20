package xin.altitude.mybatis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author explore
 * @Date 2020/12/09 17:01
 **/
@RestController
public class IndexController {
    
    @GetMapping("/test")
    public String index() {
        return "123";
    }
}
