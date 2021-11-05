/*
 * Copyright (c) 2021. 北京流深数据科技有限公司
 */

package xin.altitude.redis.cluster.mybatisplus.join2.util;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * ConvertUtils工具类用于基于Lambda表达式实现类型转换，具有如下优点：
 * 1. 实现对象转对象；集合转集合；分页对象转分页对象
 * 2. 实体类转Vo、实体类转DTO等都能应用此工具类
 * 3. 转换参数均为不可变类型，业务更加安全
 *
 * @author explore
 * @since 2021/06/19 17:23
 **/
public class ConvertUtils {
    /**
     * 将对象以一种类型转换成另一种类型
     *
     * @param <T>    源数据类型
     * @param <R>    变换后数据类型
     * @param source 源List集合
     * @param action 映射Lmabda表达式
     * @return 变换后的类型，如果source为null,则返回null
     */
    public static <T, R> R convertObj(final T source, final Function<? super T, ? extends R> action) {
        Objects.requireNonNull(action);
        return Optional.ofNullable(source).map(action).orElse(null);
    }
    
    /**
     * 将List集合以一种类型转换成另一种类型
     *
     * @param <T>    源数据类型
     * @param <R>    变换后数据类型
     * @param source 源List集合
     * @param action 映射Lmabda表达式
     * @return 变换后的类型集合，如果source为null,则返回空集合
     */
    public static <T, R> List<R> convertList(final List<T> source, final Function<? super T, ? extends R> action) {
        Objects.requireNonNull(action);
        if (Objects.nonNull(source)) {
            return source.stream().map(action).collect(toList());
        }
        return new ArrayList<>();
    }
    
    /**
     * 将IPaged对象以一种类型转换成另一种类型
     *
     * @param <T>    源数据类型
     * @param <R>    变换后数据类型
     * @param source 源IPage对象
     * @param action 映射Lmabda表达式
     * @return 变换后的类型集合，如果source为null,则返回null
     */
    public static <T, R> IPage<R> convertPage(IPage<? extends T> source, final Function<? super T, ? extends R> action) {
        Objects.requireNonNull(source);
        List<R> collect = source.getRecords().stream().map(action).collect(toList());
        return ((IPage<R>) source).setRecords(collect);
    }
    
}
