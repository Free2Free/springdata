package xin.altitude.mybatisplus.mybatisplus.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.mybatisplus.mybatisplus.entity.User;
import xin.altitude.mybatisplus.mybatisplus.mapper.UserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author explore
 * @date 2020/10/30 11:30
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 按照主键查询
     */
    @GetMapping("/user/select")
    public User getUserById(@Param("uid") Integer uid) {
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
        userMapper.insert(user);
        return user;
    }

    /**
     * 删除数据
     */
    @PostMapping("/user/delete")
    public void deleteUserById(@Param("uid") String uid){
        userMapper.deleteById(uid);
    }

    /**
     * 更新数据
     */
    @PostMapping("/user/update")
    public User updateUser(User user){
        userMapper.updateById(user);
        return userMapper.selectById(user.getUid());
    }
}
