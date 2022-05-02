package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Node;

/**
 * (Node)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:29
 */
public interface NodeDao extends BaseMapper<Node> {

    int insert(Node record);

    int insertSelective(Node record);

    int update(Node record);

    int updateSelective(Node record);

    Node queryOne(Integer nodeId);

    int delete(Integer nodeId);
}

