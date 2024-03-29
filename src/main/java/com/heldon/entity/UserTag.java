package com.heldon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class UserTag {
    @TableId(value = "tagging_id", type = IdType.AUTO)
    private Integer taggingId;
    private Integer taggingType;
    private Integer tagId;
    private Integer targetId;
    private Date createTime;
    @TableLogic
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

}
