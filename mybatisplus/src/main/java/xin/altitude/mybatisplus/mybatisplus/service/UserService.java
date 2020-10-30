package xin.altitude.mybatisplus.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xin.altitude.mybatisplus.mybatisplus.entity.User;
import xin.altitude.mybatisplus.mybatisplus.mapper.UserMapper;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/30 14:53
 */
@Service
public interface UserService extends IService<User> {
}
