package xin.altitude.redis.cluster.mybatisplus.join.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.redis.cluster.mybatisplus.join.entity.Book;
import xin.altitude.redis.cluster.mybatisplus.join.mapper.BookMapper;
import xin.altitude.redis.cluster.mybatisplus.join.service.BookService;

import javax.annotation.Resource;

/**
 * @author explore
 * @date 2020/11/14 16:47
 */
@RestController
public class BookController {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private BookService bookService;
    
    @GetMapping("/book/{id}")
    public Book index(@PathVariable Long id) {
        return bookService.getById(id);
    }
    
    @GetMapping("/aa/{id}")
    public Book index2(@PathVariable Long id) {
        return bookMapper.selectById(id);
    }
    
    @PostMapping("/book")
    public Book index3(Book book) {
        bookService.save(book);
        return book;
    }
}
