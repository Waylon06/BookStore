package com.waylon.serverbookstore.services.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waylon.serverbookstore.mapper.BookMapper;
import com.waylon.serverbookstore.moudels.Book;
import com.waylon.serverbookstore.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Waylon
 */
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectAll() {
        List<Book> books = bookMapper.selectList(null);
        System.out.println(books);
        return books;
    }

    @Override
    public List<Book> selectByName(Book book) {
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper();
        bookQueryWrapper.eq("book_name", book.getBname());
        List<Book> books = bookMapper.selectList(bookQueryWrapper);
        return books;
    }

}
