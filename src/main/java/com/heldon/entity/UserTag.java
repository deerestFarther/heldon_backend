package com.heldon.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter


public class UserTag {

    private Integer taggingId;
    private Integer taggingType;
    private Integer tagId;
    private Integer targetId;
    private Date createTime;
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

}
