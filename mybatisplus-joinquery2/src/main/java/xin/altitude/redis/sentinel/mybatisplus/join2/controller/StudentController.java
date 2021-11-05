package xin.altitude.redis.cluster.mybatisplus.join2.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.redis.cluster.mybatisplus.join2.base.common.AjaxResult;
import xin.altitude.redis.cluster.mybatisplus.join2.base.entity.PageEntity;
import xin.altitude.redis.cluster.mybatisplus.join2.domain.Student;
import xin.altitude.redis.cluster.mybatisplus.join2.mapper.StudentMapper;
import xin.altitude.redis.cluster.mybatisplus.join2.service.IStudentService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/front/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private StudentMapper studentMapper;
    
    @GetMapping("/page")
    public AjaxResult list(PageEntity pageEntity, Student student) {
        return AjaxResult.success(studentMapper.selectPage(pageEntity.toPage(), Wrappers.lambdaQuery(student)));
    }
    
    @GetMapping("/list")
    public AjaxResult list(Student student) {
        List<Student> list = student.selectList(Wrappers.lambdaQuery(student));
        return AjaxResult.success(list);
    }
    
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Student student) {
        return AjaxResult.success(student.insert());
    }
    
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Student student) {
        return AjaxResult.success(student.updateById());
    }
    
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(studentMapper.deleteBatchIds(Arrays.asList(ids)));
    }
    
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(studentMapper.selectById(id));
    }
    
    //*****增加方法
    @GetMapping("/sasa/{id}")
    public AjaxResult sasa(@PathVariable Integer id) {
        return AjaxResult.success(studentService.getStudent(id));
    }
    
    @GetMapping("/sasa/dd")
    public AjaxResult sasadd() {
        return AjaxResult.success(studentService.getStudentList());
    }
    
    @GetMapping("/sasa/tt")
    public AjaxResult sasatt(Page<Student> page) {
        return AjaxResult.success(studentService.getStudentPage(page));
    }
}
