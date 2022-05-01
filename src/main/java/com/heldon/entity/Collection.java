package com.heldon.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter


public class Collection {

    private Integer collectionId;
    private Integer userId;
    private Integer collectionType;
    private String collectionName;
    private String content;
    private Integer commentCount;
    private Date createTime;
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

}
