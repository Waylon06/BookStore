package com.waylon.serverbookstore.services;

import com.waylon.serverbookstore.moudels.Book;

import java.util.List;

/**
 * @author Waylon
 */
public interface IBookService {
    List<Book> selectAll();

    List<Book> selectByName(Book book);
}
