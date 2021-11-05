package xin.altitude.redis.cluster.mybatisplus.join.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xin.altitude.redis.cluster.mybatisplus.join.entity.Passenger;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/31 10:57
 */
@Mapper
public interface PassengerMapper extends BaseMapper<Passenger> {
    /**
     * 查询乘客信息
     */
    Passenger getPassengerInfo(@Param("id") Integer id);

    /**
     * 查询所有乘客
     * @return
     */
    List<Passenger> getAllPassengerInfo();
}
