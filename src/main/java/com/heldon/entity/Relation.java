/*
 * This file is generated by MybatisHelperPro plug-in. For details, please see：
 *
 * https://gitee.com/lsl-gitee/LDevKit/tree/master/MybatisHelperPro
 * or
 * https://plugins.jetbrains.com/plugin/15913-mybatishelperpro
 */
package com.heldon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MybatisHelperPro
 * @since 2022/05/31 17:28
 */
@Data
@ToString
@Getter
@Setter
public class Relation {

    @TableId(value = "edge_id", type = IdType.AUTO)
    private Integer edgeId;

    private Integer nodeIdFrom;

    private Integer nodeIdTo;

    private String edgeName;

    private String content;

    /**
     * 创建时间/修改时间
     */
    private Date createTime;

    @TableLogic
    private Boolean isDelete;

    private Integer ext1;

    private Integer ext2;

    private String ext3;

    private String ext4;
}