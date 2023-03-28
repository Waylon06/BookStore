package com.waylon.serverbookstore.services;

import com.waylon.serverbookstore.moudels.User;

/**
 * @author Waylon
 */
public interface IUserService {

    User verifyUser(User user);

    User registerByName(User user);

    User register(User user);
}
