package com.waylon.serverbookstore.moudels;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Waylon
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("user")
public class User {
    @TableField("user_name")
    private String username;
    @TableField("password")
    private String password;
    @TableField("email")
    private String email;
    @TableField("user_id")
    private String uid;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
