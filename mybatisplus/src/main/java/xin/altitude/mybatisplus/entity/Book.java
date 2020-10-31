package xin.altitude.mybatisplus.entity;


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
@TableName(value="")
public class Book {

	// 主键ID（全局唯一）
	@ApiModelProperty(value = "主键ID（全局唯一）", position = 0)
	@TableId
	private Long id;

	// 书名
	@ApiModelProperty(value = "书名", position = 1)
	private String name;

	// 价格
	@ApiModelProperty(value = "价格", position = 2)
	private Integer price;

	// 出版社
	@ApiModelProperty(value = "出版社", position = 3)
	private String press;

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
