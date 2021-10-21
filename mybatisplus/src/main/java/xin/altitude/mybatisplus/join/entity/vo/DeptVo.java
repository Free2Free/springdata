package xin.altitude.mybatisplus.join.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import xin.altitude.mybatisplus.join.entity.joinquery.Dept;
import xin.altitude.mybatisplus.join.entity.joinquery.User;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class DeptVo extends Dept {
    private List<User> users;
    
    public DeptVo(Dept dept) {
        super(dept);
    }
}
