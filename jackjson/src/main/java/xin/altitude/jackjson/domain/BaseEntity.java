package xin.altitude.jackjson.domain;

import java.util.Date;

/**
 * @Author explore
 * @Date 2021/02/22 16:05
 **/
public class BaseEntity {
    //*************************** 补充属性开始 ***************************
    private long version;
    private boolean deleted;
    private Date gmtCreate;
    private Date gmtModified;

    //*************************** 补充属性结束 ***************************
}
