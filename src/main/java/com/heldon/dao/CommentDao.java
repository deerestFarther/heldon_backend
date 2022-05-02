package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Comment;

/**
 * (Comment)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:26
 */
public interface CommentDao extends BaseMapper<Comment> {
    int insert(Comment record);

    int insertSelective(Comment record);

    int update(Comment record);

    int updateSelective(Comment record);

    Comment queryOne(Integer commentId);

    int delete(Integer commentId);
}

