package com.waylon.serverbookstore.moudels;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@TableName("cart")
public class Cart {
    @TableField("uid")
    private Integer uid;
    @TableField("oid")
    private Integer oid;
    @TableField("bid")
    private Integer bid;
    @TableField("num")
    private Integer num;
    private Integer oStatus;

    @Override
    public String toString() {
        return "Cart{" +
                "uid=" + uid +
                ", oid=" + oid +
                ", bid=" + bid +
                ", num=" + num +
                ", oStatus=" + oStatus +
                '}';
    }
}
