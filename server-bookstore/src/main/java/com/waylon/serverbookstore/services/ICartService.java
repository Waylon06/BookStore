package com.waylon.serverbookstore.services;

import com.waylon.serverbookstore.moudels.Book;
import com.waylon.serverbookstore.moudels.Cart;

import java.util.List;

/**
 * @author Waylon
 */
public interface ICartService {
    void insertOrder(Cart order);
    List<Book> selectOrdersByUid(Integer uid);
    void delOrder(Cart order);
    int updateOrder(Cart cart);
    List<Cart> selectFinishOrdersByUid(Integer uid);
}
