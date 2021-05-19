package xin.altitude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.service.EhCacheService;

/**
 * @Author explore
 * @Date 2021/03/05 14:58
 **/
@RestController
public class IndexController {
    @Autowired
    private EhCacheService ehCacheService;
    
    @GetMapping("/index")
    public String index() {
        return ehCacheService.getData();
    }
}
