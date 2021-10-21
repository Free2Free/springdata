package xin.altitude.mybatisplus.join.service;

import xin.altitude.mybatisplus.join.entity.Passenger;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/31 11:49
 */
public interface PassengerService {
    Passenger getPassengerInfo(Integer id);

    List<Passenger> getPassengerInfo();

}
