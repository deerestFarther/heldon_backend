package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Relation;

/**
 * (Relation)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:29
 */
public interface RelationDao extends BaseMapper<Relation> {

    int insert(Relation record);

    int insertSelective(Relation record);

    int update(Relation record);

    int updateSelective(Relation record);

    Relation queryOne(Integer edgeId);

    int delete(Integer edgeId);
}

