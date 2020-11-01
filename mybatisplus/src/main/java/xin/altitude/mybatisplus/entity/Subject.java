package xin.altitude.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value="tb_subject")
@JsonInclude(JsonInclude.Include.NON_NULL)		// 返回json数据为null的字段将被过滤
public class Subject {

	// 主键ID（全局唯一）
	@ApiModelProperty(value = "主键ID（全局唯一）", position = 0)
	@TableId
	private Long id;

	// 课程名
	@ApiModelProperty(value = "课程名", position = 1)
	private String name;

	// 学分
	@ApiModelProperty(value = "学分", position = 2)
	private Integer credit;

	// 成绩，不存在与当前表中
	@TableField(exist = false)
	private Integer grade;

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
