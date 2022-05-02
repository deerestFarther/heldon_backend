package com.heldon.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (UserTag)表实体类
 *
 * @author makejava
 * @since 2022-05-02 10:54:31
 */
@SuppressWarnings("serial")
public class UserTag extends Model<UserTag> {

    private Integer taggingId;
    //（0：用户；1：关系网：2关系网收藏夹）
    private Integer taggingType;

    private Integer tagId;
    //!待添加外键，标识贴标签的对象的id
    private Integer targetId;

    private Date createTime;

    private Integer isDelete;

    private Integer ext1;

    private Integer ext2;

    private String ext3;

    private String ext4;


    public Integer getTaggingId() {
        return taggingId;
    }

    public void setTaggingId(Integer taggingId) {
        this.taggingId = taggingId;
    }

    public Integer getTaggingType() {
        return taggingType;
    }

    public void setTaggingType(Integer taggingType) {
        this.taggingType = taggingType;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getExt1() {
        return ext1;
    }

    public void setExt1(Integer ext1) {
        this.ext1 = ext1;
    }

    public Integer getExt2() {
        return ext2;
    }

    public void setExt2(Integer ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.taggingId;
    }
}

