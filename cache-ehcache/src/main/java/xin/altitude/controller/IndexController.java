package xin.altitude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.service.EhCacheService;

import java.time.LocalDateTime;

/**
 * @Author explore
 * @Date 2021/03/05 14:58
 **/
@RestController
public class IndexController {
    @Autowired
    private EhCacheService ehCacheService;
    
    @GetMapping("/index")
    public LocalDateTime index() {
        return ehCacheService.getData();
    }
}
