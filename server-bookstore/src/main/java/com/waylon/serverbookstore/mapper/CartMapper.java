package com.waylon.serverbookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waylon.serverbookstore.moudels.Book;
import com.waylon.serverbookstore.moudels.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Waylon
 */
@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    @Select("select b.book_id as bid, b.book_name as bname, b.new_price, b.cover, b.details, c.num from (select * from cart where uid = #{uid}) as c, book as b where b.book_id = c.bid")
    List<Book> selectOrdersByUid(Integer uid);
}
