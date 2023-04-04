package com.waylon.serverbookstore.services.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.waylon.serverbookstore.mapper.CartMapper;
import com.waylon.serverbookstore.moudels.Book;
import com.waylon.serverbookstore.moudels.Cart;
import com.waylon.serverbookstore.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Waylon
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;


    @Override
    public void insertOrder(Cart order) {
        int i = cartMapper.insert(order);
        System.out.println(i);
    }

    @Override
    public List<Book> selectOrdersByUid(Integer uid) {
        return cartMapper.selectOrdersByUid(uid);
    }

    @Override
    public void delOrder(Cart order) {
        QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
        cartQueryWrapper.eq("uid", order.getUid());
        cartQueryWrapper.eq("bid", order.getBid());
        cartMapper.delete(cartQueryWrapper);
    }

    @Override
    public int updateOrder(Cart cart) {
        UpdateWrapper<Cart> cartUpdateWrapper = new UpdateWrapper<>();
        cartUpdateWrapper.set("o_status", 1);
        cartUpdateWrapper.eq("uid", cart.getUid());
        cartUpdateWrapper.eq("bid", cart.getBid());
        cartMapper.update(cart,cartUpdateWrapper);
        return 0;
    }

    @Override
    public List<Cart> selectFinishOrdersByUid(Integer uid) {
        QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
        cartQueryWrapper.eq("uid", uid);
        cartQueryWrapper.eq("o_status",1);
        return cartMapper.selectList(cartQueryWrapper);
    }
}
