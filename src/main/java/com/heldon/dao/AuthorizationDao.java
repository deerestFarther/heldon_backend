package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Authorization;

/**
 * (Authorization)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:25
 */
public interface AuthorizationDao extends BaseMapper<Authorization> {
    int insert(Authorization record);

    int insertSelective(Authorization record);

    int update(Authorization record);

    int updateSelective(Authorization record);

    Authorization queryOne(Integer authId);

    int delete(Integer authId);
}

