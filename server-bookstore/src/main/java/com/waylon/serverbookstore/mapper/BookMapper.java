package com.waylon.serverbookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waylon.serverbookstore.moudels.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Waylon
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
