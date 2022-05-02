package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.User;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:31
 */
public interface UserDao extends BaseMapper<User> {

    int insert(User record);

    int insertSelective(User record);

    int update(User record);

    int updateSelective(User record);

    User queryOne(Integer userId);

    int delete(Integer userId);
}

