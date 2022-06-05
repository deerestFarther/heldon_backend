package com.heldon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@ToString
@Data
@Accessors(chain = true)
public class User {
    @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId;
    private String nickname;
    private String avatar;
    private Date createTime;
    @TableLogic
    private Boolean isDelete;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;


}
