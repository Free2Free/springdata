package xin.altitude.mybatisplus.entity.joinquery;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 连接查询实体
 *
 * @Author explore
 * @Date 2021/05/24 10:18
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class XUser {
    @TableId()
    private Integer userId;
    private String userName;
    private Integer deptId;
    
    public XUser(XUser xUser) {
        this.userId = xUser.getUserId();
        this.userName = xUser.getUserName();
        this.deptId = xUser.getDeptId();
    }
}
