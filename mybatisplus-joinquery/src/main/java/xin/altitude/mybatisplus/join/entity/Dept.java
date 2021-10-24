package xin.altitude.mybatisplus.join.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@TableName("tb_dept")
public class Dept {
    @TableId()
    private Integer deptId;
    private String deptName;
    
    public Dept(Dept dept) {
        Optional.ofNullable(dept).ifPresent(e -> {
            this.deptId = e.getDeptId();
            this.deptName = e.getDeptName();
        });
    }
}
