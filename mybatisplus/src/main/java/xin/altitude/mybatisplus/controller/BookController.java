package xin.altitude.mybatisplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.mybatisplus.entity.Book;
import xin.altitude.mybatisplus.service.BookService;

import javax.annotation.Resource;

/**
 * @author explore
 * @date 2020/11/14 16:47
 */
@RestController
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping("/book")
    public Book index(){
        return bookService.getById(1322022492223426561L);
    }
}
