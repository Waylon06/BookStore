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
@NoArgsConstructor
@AllArgsConstructor

@TableName("notice")
public class Notice {
    @TableField("notice_id")
    private Integer nid;
    @TableField("title")
    private String title;
    @TableField("content")
    private String content;
    @TableField("time")
    private String time;

    @Override
    public String toString() {
        return "Notice{" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
