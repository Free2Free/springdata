package xin.altitude.redis.cluster.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author explore
 * @Date 2021/05/16 22:04
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class User implements Serializable {
    private Integer userId;
    private String userName;
    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    
    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}