package xin.altitude.redis.cluster.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author explore
 * @Date 2021/05/22 19:26
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XUser {
    private Integer userId;
    private String UserName;
    private Integer age;
}
