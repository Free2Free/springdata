package xin.altitude.redis.cluster.mybatisplus.join.service;

import xin.altitude.redis.cluster.mybatisplus.join.entity.Passenger;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/31 11:49
 */
public interface PassengerService {
    Passenger getPassengerInfo(Integer id);

    List<Passenger> getPassengerInfo();

}
