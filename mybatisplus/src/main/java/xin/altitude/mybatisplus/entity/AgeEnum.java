package xin.altitude.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author explore
 * @date 2020/11/18 15:44
 */
public enum AgeEnum implements IEnum<Integer> {
    ONE(1, "一岁"),
    TWO(2, "二岁"),
    THREE(3, "三岁");

    @EnumValue
    private Integer value;
    @JsonValue
    private String desc;

    AgeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
