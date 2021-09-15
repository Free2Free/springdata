package xin.altitude.caffeine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.caffeine.service.CaffeineService;

/**
 * @author explore
 * @since 2021/07/05 14:23
 **/
@RestController
public class CaffeineController {
    @Autowired
    private CaffeineService caffeineService;
    
    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") Integer id) {
        return caffeineService.getData(id);
    }
    
    
    @GetMapping("/index2")
    public String index2(@RequestParam(defaultValue = "2") Integer id) {
        return caffeineService.getData2(id);
    }
}
