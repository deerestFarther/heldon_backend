package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.FondNetwork;

/**
 * (FondNetwork)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:28
 */
public interface FondNetworkDao extends BaseMapper<FondNetwork> {

    int insert(FondNetwork record);

    int insertSelective(FondNetwork record);

    int update(FondNetwork record);

    int updateSelective(FondNetwork record);

    FondNetwork queryOne(Integer fondId);

    int delete(Integer fondId);
}

