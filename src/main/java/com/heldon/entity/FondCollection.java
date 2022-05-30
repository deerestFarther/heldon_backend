package com.heldon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter


public class FondCollection {
    @TableId(value = "fond_id",type = IdType.AUTO)
    private Integer fondId;
    private Long userId;
    private Integer collectionId;
    private Integer isLike;
    private Date createTime;
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;


}
