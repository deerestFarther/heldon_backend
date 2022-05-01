package com.heldon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过user_id查找用户全部信息
     *
     * @param userId
     * @return 全部的（一般是一个）User对象，目前仅考虑用List接受
     */
    List<User> selectUserByUserId(Integer userId);

    /**
     * 插入一个User的基本信息
     *
     * @param nickname 用户昵称
     * @return 插入的记录数
     */
    int insertUser(String nickname);

    /**
     * 修改用户头像
     * @param userId 用户id
     * @param url 头像资源存储路径
     * @return
     */
    int updateUserAvatar(Integer userId, String url);

    /**
     * 修改用户的昵称
     * @param userId 用户id
     * @param nickname 修改之后的昵称
     * @return
     */
    int updateUserNickname(Integer userId, String nickname);


}
