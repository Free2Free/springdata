package xin.altitude.mybatisplus.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xin.altitude.mybatisplus.mybatisplus.entity.Passenger;

/**
 * @author explore
 * @date 2020/10/31 10:57
 */
@Mapper
public interface PassengerMapper extends BaseMapper<Passenger> {
    /**
     * 查询乘客信息
     */
    public Passenger getPassengerInfo(@Param("id") Integer id);
}
