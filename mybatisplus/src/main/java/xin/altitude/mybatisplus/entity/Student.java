package xin.altitude.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value="tb_student")
public class Student {

	// 主键ID（全局唯一）
	@ApiModelProperty(value = "主键ID（全局唯一）", position = 0)
	@TableId
	private Long id;

	// 姓名
	@ApiModelProperty(value = "姓名", position = 1)
	private String name;

	// 年龄
	@ApiModelProperty(value = "年龄", position = 2)
	private Integer age;

	// 选课科目
	@TableField(exist = false)
	private List<Subject> subjects;

	// 逻辑删除（0:未删除；1:已删除）
	@ApiModelProperty(value = "逻辑删除（0:未删除；1:已删除）", position = 3)
	@TableField(select = false)
	private String deleted;

	// 乐观锁
	@ApiModelProperty(value = "乐观锁", position = 4)
	@Version
	private Integer version;

	// 创建时间
	@ApiModelProperty(value = "创建时间", position = 5)
	private java.util.Date gmtCreate;

	// 修改时间
	@ApiModelProperty(value = "修改时间", position = 6)
	private java.util.Date gmtModified;


}
