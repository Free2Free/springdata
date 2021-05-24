package xin.altitude.mybatisplus.entity.joinquery;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author explore
 * @Date 2021/05/24 10:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_dept")
@ToString(callSuper = true)
public class XDept {
    @TableId()
    private Integer deptId;
    private String deptName;
    
    public XDept(XDept xDept) {
        this.deptId = xDept.getDeptId();
        this.deptName = xDept.getDeptName();
    }
}
