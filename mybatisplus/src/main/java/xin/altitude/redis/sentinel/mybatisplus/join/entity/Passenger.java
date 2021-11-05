package xin.altitude.redis.cluster.mybatisplus.join.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value="tb_passenger")
public class Passenger {

	// 主键ID
	@ApiModelProperty(value = "主键ID", position = 0)
	@TableId
	private Long id;

	// 姓名
	@ApiModelProperty(value = "姓名", position = 1)
	private String name;

	// 性别
	@ApiModelProperty(value = "性别", position = 2)
	private String sex;

	// 出生日期
	@ApiModelProperty(value = "出生日期", position = 3)
	private String birthday;
	
	// 乘客里面有护照信息（不存在表中）
	@TableField(exist = false)
	private xin.altitude.redis.cluster.mybatisplus.join.entity.Passport passport;
}
