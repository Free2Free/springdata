package xin.altitude.jackjson.controller;/**
 * @author explore
 * @date 2020/11/14 15:21
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.jackjson.domain.BModel;
import xin.altitude.jackjson.service.BModelService;

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
}
