package xin.altitude.jackjson.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author explore
 * @Date 2021/02/22 16:05
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    //*************************** 补充属性开始 ***************************
    private long version;
    @JsonProperty()
    private boolean deleted;
    private Date gmtCreate;
    private Date gmtModified;

    //*************************** 补充属性结束 ***************************
}
