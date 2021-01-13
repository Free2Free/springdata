package xin.altitude.word.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author explore
 * @Date 2021/01/13 20:20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    private String module;
    private String item;
    private String scope;
    private String desc;
}
