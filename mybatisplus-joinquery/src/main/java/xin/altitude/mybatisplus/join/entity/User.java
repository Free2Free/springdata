package xin.altitude.mybatisplus.join.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@TableName("sys_user")
public class User {
    @TableId()
    private Integer userId;
    private String userName;
    private Integer deptId;
    
    public User(User user) {
        Optional.ofNullable(user).ifPresent(e -> {
            this.userId = e.getUserId();
            this.userName = e.getUserName();
            this.deptId = e.getDeptId();
        });
    }
}