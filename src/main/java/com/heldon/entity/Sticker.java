package com.heldon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter


public class Sticker {
    @TableId(value = "sticker_id",type = IdType.AUTO)
    private Integer stickerId;
    private Long userId;
    private Integer targetId;
    private Integer targetType;
    private String content;
    private Date createTime;
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;


}
