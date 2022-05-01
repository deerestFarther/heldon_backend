package com.heldon.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter


public class Node {

    private Integer nodeId;
    private Integer netId;
    private String nodeName;
    private String content;
    private Integer X;
    private Integer Y;
    private String picUrl;
    private Date createTime;
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

}
