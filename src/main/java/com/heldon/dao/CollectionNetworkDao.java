package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.CollectionNetwork;

/**
 * (CollectionNetwork)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:26
 */
public interface CollectionNetworkDao extends BaseMapper<CollectionNetwork> {
    int insert(CollectionNetwork record);

    int insertSelective(CollectionNetwork record);

    int update(CollectionNetwork record);

    int updateSelective(CollectionNetwork record);

    CollectionNetwork queryOne(Integer containsId);

    int delete(Integer containsId);
}

