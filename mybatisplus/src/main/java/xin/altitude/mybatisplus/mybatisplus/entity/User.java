package xin.altitude.mybatisplus.mybatisplus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户实体对应表 user
 * </p>
 *
 * @author hubin
 * @since 2018-08-11
 */
@Data
public class User {
    /**
     * 指定id生成算法
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long uid;
    private String name;
    private Integer age;
    private String email;


    @TableField(select = false)
    private Integer deleted;
    @Version
    private int version;
}