package xin.altitude.redis.cluster.mybatisplus.join2.entity.bo;

import lombok.Data;
import xin.altitude.redis.cluster.mybatisplus.join2.domain.Subject;

/**
 * @author explore
 * @since 2021/10/23 21:25
 **/
@Data
public class SubjectBo extends Subject {
    /**
     * 分数
     */
    private Integer score;
    
    public SubjectBo(Subject subject) {
        super(subject);
    }
}
