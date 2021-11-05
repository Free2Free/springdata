package xin.altitude.redis.cluster.swagger.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.redis.cluster.swagger.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author explore
 * @date 2020/11/01 12:42
 */
@RestController
public class IndexController {
    @GetMapping("/list")
    @ApiOperation(value = "查询所有内容")
    public List<User> index(){
        List<User> lists = new ArrayList<User>();

        return lists;
    }

    @GetMapping("/list/{id}")
    @ApiOperation(value = "根据ID查询内容")
    public User getDataById(@PathVariable("id") String id){
        List<User> lists = new ArrayList<User>();

        return new User();
    }
}
