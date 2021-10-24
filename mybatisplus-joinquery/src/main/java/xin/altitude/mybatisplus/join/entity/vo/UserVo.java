package xin.altitude.mybatisplus.join.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import xin.altitude.mybatisplus.join.entity.User;


/**
 * @author explore
 */
@Data
@EqualsAndHashCode(callSuper = true)
// @NoArgsConstructor
// @AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class UserVo extends User {
    private String deptName;
    
    public UserVo(User user) {
        super(user);
    }
}