package xin.altitude.mybatisplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.mybatisplus.entity.Student;
import xin.altitude.mybatisplus.mapper.StudentMapper;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/31 11:23
 */
@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/student/list")
    public List<Student> getAllPassenger(){
        return studentMapper.getAllStuSubject();
    }
}
