package com.heldon.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (CollectionNetwork)表实体类
 *
 * @author makejava
 * @since 2022-05-02 10:54:26
 */
@SuppressWarnings("serial")
public class CollectionNetwork extends Model<CollectionNetwork> {

    private Integer containsId;
    //外键
    private Integer collectionId;
    //外键
    private Integer netId;
    //收藏时间
    private Date createTime;

    private Integer isDelete;

    private Integer ext1;

    private Integer ext2;

    private String ext3;

    private String ext4;


    public Integer getContainsId() {
        return containsId;
    }

    public void setContainsId(Integer containsId) {
        this.containsId = containsId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getNetId() {
        return netId;
    }

    public void setNetId(Integer netId) {
        this.netId = netId;
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
        return this.containsId;
    }
}

