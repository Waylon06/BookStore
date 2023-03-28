package com.waylon.serverbookstore.controllers;

import com.waylon.serverbookstore.moudels.User;
import com.waylon.serverbookstore.services.IUserService;
import com.waylon.serverbookstore.utils.Code;
import com.waylon.serverbookstore.utils.Respond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Waylon
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public Respond verifyUser(@RequestBody User user) {
        String uname = user.getUsername();
        String psw = user.getPassword();
        System.out.println(uname+psw);
        if (uname.equals("") || psw.equals("")) {
            return new Respond(100, "用户名或密码不能为空", null);
        }else {
            User userData = userService.verifyUser(user);
            if (userData != null) {
                return new Respond(Code.SUCCESS, "操作成功", userData);
            }else {
                return new Respond(500, "用户不存在/密码错误", "");
            }
        }
    }

    @PostMapping("/register")
    public Respond register(@RequestBody User user) {
        String uname = user.getUsername();
        String psw = user.getPassword();
        String email = user.getEmail();
        if (uname.equals("") || psw.equals("") || email.equals("")) {
            return new Respond(100, "用户名或密码、邮箱不能为空", null);
        }else {
            User isExist = userService.registerByName(user);
            if (isExist == null) {
                userService.register(user);
                User userData = userService.verifyUser(user);
                return new Respond(200,"注册成功", userData);
            }else {
                return new Respond(500, "注册失败", "用户已存在");
            }
        }
    }
}
