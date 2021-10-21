package xin.altitude.mybatisplus.join.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_book")
@JsonIgnoreProperties({"deleted", "gmtCreate", "gmtModified"})
public class Book extends Model<Book> {
    // 主键ID（全局唯一）
    @TableId
    private Long id;
    // 书名
    private String name;
    // 价格
    private Integer price;
    // 出版社
    private String press;
    // 逻辑删除（0:未删除；1:已删除）
	private Boolean deleted;
	// 乐观锁
	@Version
	private Integer version;
	// 创建时间
	private java.util.Date gmtCreate;
	// 修改时间
	private java.util.Date gmtModified;
}
