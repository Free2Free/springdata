package xin.altitude.mybatisplus.mybatisplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.mybatisplus.mybatisplus.entity.Passenger;
import xin.altitude.mybatisplus.mybatisplus.service.PassengerService;

/**
 * @author explore
 * @date 2020/10/31 11:23
 */
@RestController
public class PassengerController {
    @Autowired
    private PassengerService PassengerService;

    @GetMapping("/passenger/list/{id}")
    public Passenger index(@PathVariable("id") Integer id){
        //Integer id = 1;
        return PassengerService.getPassengerInfo(id);
    }
}
