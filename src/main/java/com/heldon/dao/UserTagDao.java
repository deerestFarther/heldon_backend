package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.UserTag;

/**
 * (UserTag)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:31
 */
public interface UserTagDao extends BaseMapper<UserTag> {

    int insert(UserTag record);

    int insertSelective(UserTag record);

    int update(UserTag record);

    int updateSelective(UserTag record);

    UserTag queryOne(Integer taggingId);

    int delete(Integer taggingId);
}

