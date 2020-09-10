package com.hzy.kafkatool.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("test")
public class HotMessage {

    private Integer id;
    private String content;
    private String timez;
    private String category;
    private String collect_time;

}
