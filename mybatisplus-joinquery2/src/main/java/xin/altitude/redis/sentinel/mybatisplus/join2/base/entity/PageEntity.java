/*
 * Copyright (c) 2021. 北京流深数据科技有限公司
 */

package xin.altitude.redis.cluster.mybatisplus.join2.base.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 前台向后端传递参数接受分页类
 *
 * @author explore
 * @since 2021/05/28 16:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageEntity {
    private long current = 1;
    private long size = 10;
    
    /**
     * 转换为MybatisPlus分页对象
     *
     * @return 分页实体
     */
    public <T> Page<T> toPage() {
        return toPage(null);
    }
    
    /**
     * 转换为MybatisPlus分页对象
     *
     * @param clazz 分页实体类类型
     * @return 分页实体
     */
    public <T> Page<T> toPage(Class<T> clazz) {
        return new Page<T>(current, size);
    }
}
