package com.waylon.serverbookstore.services.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waylon.serverbookstore.mapper.UserMapper;
import com.waylon.serverbookstore.moudels.User;
import com.waylon.serverbookstore.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Waylon
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User verifyUser(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", user.getUsername());
        User result = userMapper.selectOne(queryWrapper);
        System.out.println(result);
        if (result.getPassword().equals(user.getPassword())) {
            return result;
        }
        return null;
    }

    @Override
    public User registerByName(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", user.getUsername());
        User result = userMapper.selectOne(queryWrapper);
        return result;
    }

    @Override
    public User register(User user) {
        int insert = userMapper.insert(user);
        System.out.println(insert);
        return null;
    }


}
