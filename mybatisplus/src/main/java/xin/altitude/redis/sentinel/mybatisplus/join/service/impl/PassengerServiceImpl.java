package xin.altitude.redis.cluster.mybatisplus.join.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.redis.cluster.mybatisplus.join.entity.Passenger;
import xin.altitude.redis.cluster.mybatisplus.join.mapper.PassengerMapper;
import xin.altitude.redis.cluster.mybatisplus.join.service.PassengerService;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/31 11:40
 */
@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerMapper passengerMapper;

    @Override
    public Passenger getPassengerInfo(Integer id){
        return passengerMapper.getPassengerInfo(id);
    }

    @Override
    public List<Passenger> getPassengerInfo() {
        return passengerMapper.getAllPassengerInfo();
    }
}
