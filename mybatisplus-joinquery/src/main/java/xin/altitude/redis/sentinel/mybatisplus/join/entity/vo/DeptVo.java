package xin.altitude.redis.cluster.mybatisplus.join.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import xin.altitude.redis.cluster.mybatisplus.join.entity.Dept;
import xin.altitude.redis.cluster.mybatisplus.join.entity.User;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
// @NoArgsConstructor
// @AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class DeptVo extends Dept {
    private List<User> users;
    
    public DeptVo(Dept dept) {
        super(dept);
    }
}
