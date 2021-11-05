package xin.altitude.redis.cluster.mybatisplus.join.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.redis.cluster.mybatisplus.join.entity.Passenger;
import xin.altitude.redis.cluster.mybatisplus.join.mapper.PassengerMapper;
import xin.altitude.redis.cluster.mybatisplus.join.service.PassengerService;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/31 11:23
 */
@RestController
public class PassengerController {
    @Autowired
    private PassengerService PassengerService;

    @Autowired
    private PassengerMapper passengerMapper;

    @GetMapping("/passenger/list/{id}")
    public Passenger index(@PathVariable("id") Integer id){
        //Integer id = 1;
        return PassengerService.getPassengerInfo(id);
    }

    @GetMapping("/passenger/list")
    public List<Passenger> getAllPassenger(){
        //Integer id = 1;
        return passengerMapper.getAllPassengerInfo();
    }
}
