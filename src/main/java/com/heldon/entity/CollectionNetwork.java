package com.heldon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter


public class CollectionNetwork {
    @TableId(value = "contains_id", type = IdType.AUTO)
    private Integer containsId;
    private Integer collectionId;
    private Integer netId;
    private Date createTime;
    @TableLogic
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

}
