package xin.altitude.mybatisplus.join.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xin.altitude.mybatisplus.join.entity.User;
import xin.altitude.mybatisplus.join.mapper.UserMapper;
import xin.altitude.mybatisplus.join.service.UserService;

/**
 * @author explore
 * @date 2020/10/30 17:05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
