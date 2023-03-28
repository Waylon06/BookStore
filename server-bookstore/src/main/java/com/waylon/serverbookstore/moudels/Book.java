package com.waylon.serverbookstore.moudels;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

@TableName("book")
public class Book {
    @TableField("book_id")
    private Integer bid;
    @TableField("book_name")
    private String bname;
    @TableField("details")
    private String details;
//    @TableField("old_price")
    private Double oldPrice;
//    @TableField("new_price")
//    mybatisPlus 默认开启了驼峰转下划线
    private Double newPrice;
    @TableField("cover")
    private String cover;
    @TableField("title")
    private String title;
    @TableField("type_id")
    private  Integer tid;

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", details='" + details + '\'' +
                ", oldPrice=" + oldPrice +
                ", newPrice=" + newPrice +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", tid=" + tid +
                ", num=" + num +
                '}';
    }

    private Integer num;

}
