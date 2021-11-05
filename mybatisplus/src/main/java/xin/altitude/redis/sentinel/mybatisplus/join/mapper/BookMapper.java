package xin.altitude.redis.cluster.mybatisplus.join.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import xin.altitude.redis.cluster.mybatisplus.join.entity.Book;

/**
 * @author explore
 * @date 2020/10/30 11:29
 */
@Mapper
@CacheNamespace()
public interface BookMapper extends BaseMapper<Book> {
    default String one(String id) {
        System.out.println("未走缓存通道");
        return "AAAAA";
    }
}
