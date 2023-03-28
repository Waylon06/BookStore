package com.waylon.serverbookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waylon.serverbookstore.moudels.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Waylon
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
