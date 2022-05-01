package com.heldon.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter


public class Sticker {

    private Integer stickerId;
    private Integer userId;
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
