package com.heldon.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter


public class Network {

    private Integer netId;
    private Integer userId;
    private String netName;
    private Integer commentCount;
    private Date createTime;
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;


}
