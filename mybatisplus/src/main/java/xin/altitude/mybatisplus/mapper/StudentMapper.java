package xin.altitude.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xin.altitude.mybatisplus.entity.Dept;
import xin.altitude.mybatisplus.entity.Student;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/31 10:57
 */
@Mapper
public interface StudentMapper extends BaseMapper<Dept> {

    /**
     * 查询所有学生选修课程信息
     */
    public List<Student> getAllStuSubject();
}
