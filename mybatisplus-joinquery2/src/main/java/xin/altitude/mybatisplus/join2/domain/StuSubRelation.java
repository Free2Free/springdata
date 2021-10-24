package xin.altitude.mybatisplus.join2.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 学生与课程关系表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "tb_stu_sub_relation")
public class StuSubRelation extends Model<StuSubRelation> {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 学号ID
     */
    private Integer stuId;
    /**
     * 学生ID
     */
    private Integer subId;
    /**
     * 分数
     */
    private Integer score;
}
