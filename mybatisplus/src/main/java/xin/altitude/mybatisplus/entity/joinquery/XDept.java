package xin.altitude.mybatisplus.entity.joinquery;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_dept")
public class XDept {
    @TableId()
    private Integer deptId;
    private String deptName;
    
    public XDept(XDept xDept) {
        Optional.ofNullable(xDept).ifPresent(e -> {
            this.deptId = e.getDeptId();
            this.deptName = e.getDeptName();
        });
    }
}
