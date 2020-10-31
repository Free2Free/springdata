package xin.altitude.mybatisplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.mybatisplus.entity.Dept;
import xin.altitude.mybatisplus.entity.Passenger;
import xin.altitude.mybatisplus.mapper.DeptMapper;
import xin.altitude.mybatisplus.mapper.PassengerMapper;
import xin.altitude.mybatisplus.service.PassengerService;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/31 11:23
 */
@RestController
public class DeptController {

    @Autowired
    private DeptMapper deptMapper;

    @GetMapping("/dept/list/{id}")
    public Dept index(@PathVariable("id") String id){
        return deptMapper.getDeptInfoById(id);
        //Integer id = 1;
    }

    @GetMapping("/dept/list")
    public List<Dept> getAllPassenger(){
        return deptMapper.getAllDeptInfoById();
    }
}
