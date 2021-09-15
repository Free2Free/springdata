package xin.altitude.mybatisplus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import xin.altitude.mybatisplus.entity.joinquery.XDept;
import xin.altitude.mybatisplus.entity.joinquery.XUser;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class XDeptVo extends XDept {
    private List<XUser> xUsers;
    
    public XDeptVo(XDept xDept) {
        super(xDept);
    }
}
