package xin.altitude.mybatisplus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import xin.altitude.mybatisplus.entity.joinquery.XUser;

/**
 * @Author explore
 * @Date 2021/05/24 13:19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class XUserVo extends XUser {
    private String deptName;
    
    public XUserVo(XUser xUser, String deptName) {
        super(xUser);
        this.deptName = deptName;
    }
}
