package xin.altitude.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@TableName(value="sys_user")
public class User {

	// 主键ID（全局唯一）
	@ApiModelProperty(value = "主键ID（全局唯一）", position = 0)
	@TableId
	private Long id;

	// 姓名
	@ApiModelProperty(value = "姓名", position = 1)
	private String name;

	// 年龄
	@ApiModelProperty(value = "年龄", position = 2)
	private AgeEnum age;

	// 邮箱
	@ApiModelProperty(value = "邮箱", position = 3)
	private String email;

	// 逻辑删除（0:未删除；1:已删除）
	@ApiModelProperty(value = "逻辑删除（0:未删除；1:已删除）", position = 4)
	@TableField(select = false)
	private String deleted;

	// 乐观锁
	@ApiModelProperty(value = "乐观锁", position = 5)
	@Version
	private Integer version;

	// 创建时间
	@ApiModelProperty(value = "创建时间", position = 6)
	private java.util.Date gmtCreate;

	// 修改时间
	@ApiModelProperty(value = "修改时间", position = 7)
	private java.util.Date gmtModified;

	//public User(String name, Integer age, String email) {
	//	this.name = name;
	//	this.age = age;
	//	this.email = email;
	//}
}
