package xin.altitude.lombok.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @Author explore
 * @Date 2021/05/18 15:44
 **/
//@Data
//@Builder
//@Data
@AllArgsConstructor
@Data
@ToString
public class XUser {
    private Integer userId;
    private String userName;
}
