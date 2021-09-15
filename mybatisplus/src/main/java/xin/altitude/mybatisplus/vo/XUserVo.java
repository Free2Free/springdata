package xin.altitude.mybatisplus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import xin.altitude.mybatisplus.entity.joinquery.XUser;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class XUserVo extends XUser {
    private String deptName;
    
    public XUserVo(XUser xUser) {
        super(xUser);
    }
}