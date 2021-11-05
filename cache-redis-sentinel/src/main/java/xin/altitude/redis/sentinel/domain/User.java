package xin.altitude.redis.sentinel.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author explore
 * @Date 2021/05/16 22:04
 **/
@Data
@NoArgsConstructor
// @AllArgsConstructor
// @Accessors(chain = true)
// @ToString
public class User implements Serializable {
    private static final long serialVersionUID = -7254888630210798460L;
    private Integer userId;
    private String userName;
    
    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}