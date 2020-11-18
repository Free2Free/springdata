package xin.altitude.mybatisplus.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.mybatisplus.entity.AgeEnum;
import xin.altitude.mybatisplus.entity.User;
import xin.altitude.mybatisplus.mapper.UserMapper;
import xin.altitude.mybatisplus.service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author explore
 * @date 2020/10/30 11:30
 */
@RestController
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    /**
     * 按照主键查询
     * @return
     */
    @GetMapping("/user/select/list")
    public List<User> getUserList() {
        return userMapper.selectList(null);
    }

    /**
     * 按照主键查询
     */
    @GetMapping("/user/select")
    public User getUserById(@RequestParam("uid") String uid) {
        return userMapper.selectById(uid);
    }

    /**
     * 按照条件查询呢
     */
    @PostMapping("/user/selectByCondition")
    public List<User> getUsers(User user){
        Map<String,Object> map = new HashMap<>();
        map.put("name",user.getName());
        map.put("age",user.getAge());
        return userMapper.selectByMap(map);
    }

    /**
     * 插入数据
     */
    @PostMapping("/user/insert")
    public User addUser(User user){
        user.setAge(AgeEnum.TWO);
        userMapper.insert(user);
        return user;
    }

    /**
     * 删除数据
     */
    @PostMapping("/user/delete")
    public void deleteUserById(@RequestParam("uid") String uid){
        userMapper.deleteById(uid);
    }

    /**
     * 更新数据
     */
    @PostMapping("/user/update")
    public User updateUser(User user){
        userMapper.updateById(user);
        return userMapper.selectById(user.getId());
    }

    /**
     * 批量保存
     * 前端传递json对象数组作为参数
     * @return
     */
    @PostMapping("user/batch")
    public List<User> saveByBatch(@RequestParam("users") String strs){
        System.out.println(strs);
        String ss = "[{\"name\":\"a\", \"age\":\"100\", \"email\":\"1@163.com\"},{\"name\":\"b\", \"age\":\"101\", \"email\":\"2@163.com\"}]";

        List<User> users = JSONArray.parseArray(ss, User.class);
        userService.saveBatch(users);
        return users;
    }


    /**
     * 分页查询
     */
    @PostMapping("/user/selectPage")
    public Page<User> selectByPage(){
        return userMapper.selectPage(new Page<>(2,2),null);
    }
}
