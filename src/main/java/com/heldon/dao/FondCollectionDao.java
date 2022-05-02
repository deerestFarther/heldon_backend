package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.FondCollection;

/**
 * (FondCollection)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:27
 */
public interface FondCollectionDao extends BaseMapper<FondCollection> {

    int insert(FondCollection record);

    int insertSelective(FondCollection record);

    int update(FondCollection record);

    int updateSelective(FondCollection record);

    FondCollection queryOne(Integer fondId);

    int delete(Integer fondId);
}

