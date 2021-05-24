package xin.altitude.mybatisplus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xin.altitude.mybatisplus.entity.joinquery.XDept;
import xin.altitude.mybatisplus.entity.joinquery.XUser;

import java.util.List;

/**
 * @Author explore
 * @Date 2021/05/24 13:57
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XDeptVo extends XDept {
    private List<XUser> xUsers;
    
    public XDeptVo(XDept xDept, List<XUser> xUsers) {
        super(xDept);
        this.xUsers = xUsers;
    }
}
