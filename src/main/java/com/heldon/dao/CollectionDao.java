package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Collection;

/**
 * (Collection)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:25
 */
public interface CollectionDao extends BaseMapper<Collection> {
    int insert(Collection record);

    int insertSelective(Collection record);

    int update(Collection record);

    int updateSelective(Collection record);

    Collection queryOne(Integer collectionId);

    int delete(Integer collectionId);
}

