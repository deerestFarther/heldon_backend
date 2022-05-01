package com.heldon.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Authorization {

    private Integer authId;
    private Integer userId;
    private String credentials;
    private String identifier;
    private Integer identityType;
    private Date lastloginTime;
    private String lastloginIp;
    private Date createTime;
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;


}
