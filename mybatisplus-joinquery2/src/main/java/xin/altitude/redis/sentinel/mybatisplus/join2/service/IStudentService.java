package xin.altitude.redis.cluster.mybatisplus.join2.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import xin.altitude.redis.cluster.mybatisplus.join2.domain.Student;
import xin.altitude.redis.cluster.mybatisplus.join2.entity.vo.StudentVo;

import java.util.List;

public interface IStudentService extends IService<Student> {
    StudentVo getStudent(Integer stuId);
    
    List<StudentVo> getStudentList();
    
    IPage<StudentVo> getStudentPage(IPage<Student> page);
}
