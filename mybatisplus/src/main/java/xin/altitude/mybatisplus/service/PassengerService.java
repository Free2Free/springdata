package xin.altitude.mybatisplus.service;

import xin.altitude.mybatisplus.entity.Passenger;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/31 11:49
 */
public interface PassengerService {
    Passenger getPassengerInfo(Integer id);

    List<Passenger> getPassengerInfo();

}
