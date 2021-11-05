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
public class SUser {
    private Integer userId;
    private String UserName;
    // 本应该是Double类型，错误的使用为String类型
    private String score;
}
