package com.waylon.serverbookstore.controllers;

import com.waylon.serverbookstore.moudels.Book;
import com.waylon.serverbookstore.moudels.Cart;
import com.waylon.serverbookstore.services.ICartService;
import com.waylon.serverbookstore.utils.Code;
import com.waylon.serverbookstore.utils.Respond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Waylon
 */

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private ICartService cartService;

    @PostMapping("/add")
    public Respond insertOrder(@RequestBody Cart order) {
        cartService.insertOrder(order);
        return new Respond(Code.SUCCESS, "添加成功", "null");
    }

    @GetMapping("/list")
    public Respond orderInfo(Integer uid) {
        List<Book> books = cartService.selectOrdersByUid(uid);
        if (books == null) {
            return new Respond(Code.ERROR, "没有获取到订单书籍", null);
        }
        return new Respond(Code.SUCCESS, "获取成功",books);
    }

    @DeleteMapping("/del")
    public Respond delOrder( Cart order) {
        System.out.println(order.getBid());
        System.out.println(order.getUid());
        cartService.delOrder(order);
        return new Respond(Code.SUCCESS, "删除成功", null);
    }

    @PutMapping("/submit")
    public Respond submitOrder() {
        return new Respond(Code.SUCCESS, "提交成功", null);
    }
}
