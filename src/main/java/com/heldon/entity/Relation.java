package com.heldon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter


public class Relation {
    //要不要把id换成Long类型的呢？？？
    @TableId(value = "edge_id",type = IdType.AUTO)
    private Integer edgeId;
    private Integer nodeIdFrom;
    private Integer nodeIdTo;
    private String edgeName;
    private String content;
    private Date createTime;
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;


}
