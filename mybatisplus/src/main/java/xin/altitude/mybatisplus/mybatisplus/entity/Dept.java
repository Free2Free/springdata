package xin.altitude.mybatisplus.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value="tb_dept")
public class Dept extends Model<Dept> {

	// 主键ID（全局唯一）
	@ApiModelProperty(value = "主键ID（全局唯一）", position = 0)
	@TableId
	private Long id;

	// 部门名称
	@ApiModelProperty(value = "部门名称", position = 1)
	private String name;

	// 员工
	@ApiModelProperty(value = "员工", position = 2)
	private Integer staff;

	// 联系电话
	@ApiModelProperty(value = "联系电话", position = 3)
	private String tel;

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


}
