package xin.altitude.jackjson.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类规约
 * 1. 使用明显的分隔符将业务属性与补充属性分割，增强可阅读性
 * 2. 使用Lombok减少set/get冗余代码，增强可阅读性
 * 3. JSON序列化时过滤常见补充属性
 *
 * @Author explore
 * @Date 2020/11/14 15:06
 **/
@Data
@JsonIgnoreProperties({"deleted", "gmtCreate", "gmtModified"})
@JsonPropertyOrder({"id", "name"})
public class BModel extends BaseEntity {
    //*************************** 业务属性开始 ***************************
    // id
    private Long id;
    // 姓名
    private String name;
    // 出生日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
    // 是否成年
    private Boolean adult;
    // 年龄
    private Integer age;
    // 薪资
    private BigDecimal salary;
    private String othMsg;
    //*************************** 业务属性结束 ***************************

}
