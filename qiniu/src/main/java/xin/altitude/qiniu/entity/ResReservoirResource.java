package xin.altitude.qiniu.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "")
public class ResReservoirResource {

    // 资源id
    @TableId
    private String id;

    // 调研项id
    private String resSubmitId;

    // 文件路径
    private String filePath;

    // 文件类型1.图片2.视频3.其他
    private Integer fileType;

    // 文件名
    private String fileName;

    // 创建时间
    private java.util.Date createTime;

    // 提交职员的部门id
    private String createUserId;

    // 提交人的姓名
    private String createUserName;

    // 缩略图及视频第一帧图片
    private String fileThumbPath;


}
