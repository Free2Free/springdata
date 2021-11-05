package xin.altitude.redis.cluster.jackjson.controller;/**
 * @author explore
 * @date 2020/11/14 15:21
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.redis.cluster.jackjson.domain.BModel;
import xin.altitude.redis.cluster.jackjson.service.BModelService;

/**
 * @Author explore
 * @Date 2020/11/14 15:21
 **/
@RestController
public class IndexController {
    @Autowired
    private BModelService bModelService;

    @GetMapping("/index")
    public BModel index(){
        return bModelService.getData();
    }

    @PostMapping("/data1")
    public BModel data1(@RequestBody BModel model){
        return model;
    }
}
