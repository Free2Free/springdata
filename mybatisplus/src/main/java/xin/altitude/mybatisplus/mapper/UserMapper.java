package xin.altitude.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xin.altitude.mybatisplus.entity.User;

/**
 * @author explore
 * @date 2020/10/30 11:29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
