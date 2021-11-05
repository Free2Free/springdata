package xin.altitude.redis.cluster.mybatisplus.join2.entity.vo;

import lombok.Data;
import xin.altitude.redis.cluster.mybatisplus.join2.domain.Student;
import xin.altitude.redis.cluster.mybatisplus.join2.entity.bo.SubjectBo;

import java.util.List;

/**
 * @author explore
 * @since 2021/10/23 21:24
 **/
@Data
public class StudentVo extends Student {
    /**
     * 多门课程
     */
    private List<SubjectBo> subList;
    
    public StudentVo(Student student) {
        super(student);
    }
}
