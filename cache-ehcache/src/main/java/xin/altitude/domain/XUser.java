package xin.altitude.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author explore
 * @since 2021/07/05 17:06
 **/
@Data
@Accessors(chain = true)
@Builder
public class XUser {
    private Integer userId;
    private String userName;
}
