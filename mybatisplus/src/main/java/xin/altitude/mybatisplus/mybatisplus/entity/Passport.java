package xin.altitude.mybatisplus.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value="tb_passport")
public class Passport {

	// 主键ID
	@ApiModelProperty(value = "主键ID", position = 0)
	@TableId
	private Long id;

	// 国籍
	@ApiModelProperty(value = "国籍", position = 1)
	private String nationality;

	// 过期时间
	@ApiModelProperty(value = "过期时间", position = 2)
	private String expire;

	// 所有者
	@ApiModelProperty(value = "所有者", position = 3)
	private Long owner;

	// 护照里面有乘客信息(此属性不存在表中)
	@TableField(exist = false)
	private Passenger passenger;
}
