package xin.altitude.redis.cluster.mybatisplus.join.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xin.altitude.redis.cluster.mybatisplus.join.entity.Book;
import xin.altitude.redis.cluster.mybatisplus.join.mapper.BookMapper;
import xin.altitude.redis.cluster.mybatisplus.join.service.BookService;

/**
 * @author explore
 * @date 2020/10/30 17:05
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
