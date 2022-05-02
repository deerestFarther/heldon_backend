package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Network;

/**
 * (Network)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:28
 */
public interface NetworkDao extends BaseMapper<Network> {

    int insert(Network record);

    int insertSelective(Network record);

    int update(Network record);

    int updateSelective(Network record);

    Network queryOne(Integer netId);

    int delete(Integer netId);
}

