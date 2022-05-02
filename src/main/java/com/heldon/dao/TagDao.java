package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Tag;

/**
 * (Tag)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:30
 */
public interface TagDao extends BaseMapper<Tag> {

    int insert(Tag record);

    int insertSelective(Tag record);

    int update(Tag record);

    int updateSelective(Tag record);

    Tag queryOne(Integer tagId);

    int delete(Integer tagId);

}

