package com.waylon.serverbookstore.controllers;

import com.waylon.serverbookstore.moudels.Book;
import com.waylon.serverbookstore.services.IBookService;
import com.waylon.serverbookstore.utils.Code;
import com.waylon.serverbookstore.utils.Respond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Waylon
 */
@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/list")
    public Respond bookList() {
        List<Book> books = bookService.selectAll();
        return new Respond(Code.SUCCESS,"获取成功", books);
    }

    @GetMapping("/getbook")
    public Respond selectBookByName(Book book) {
        List<Book> books = bookService.selectByName(book);
        if (books == null) {
            return new Respond(Code.ERROR, "暂无此书籍", null);
        }else {
            System.out.println(books);
            return new Respond(Code.SUCCESS, "获取成功", books);
        }
    }
}
