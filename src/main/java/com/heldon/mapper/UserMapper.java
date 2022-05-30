package com.heldon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //查
    /**
     * 通过user_id查找用户全部信息
     *
     * @param userId
     * @return 全部的（一般是一个）User对象，目前仅考虑用List接受
     */
    List<User> selectUserByUserId(Long userId);

    /**
     * 通过nickname查找用户全部信息
     *
     * @param nickname
     * @return 全部的（可能有多个）User对象，目前仅考虑用List接受
     */
    List<User> selectUserByNickname(String nickname);


    //增
    /**
     * 插入一条User记录
     * @param nickname 用户注册时获得
     * @param avatar 用户头像，可以注册时获得、可以后期改动
     * @param createTime 注册时由后端给定
     * @return
     */
    int insertUser(@Param("nickname") String nickname,
                   @Param("avatar") String avatar,
                   @Param("createTime") String createTime);

    //改
    /**
     * 按用户id修改头像字段
     * @param userId
     * @param avatar
     * @return
     */
    int updateAvatarByUserId(@Param("userId")Long userId,
                             @Param("avatar")String avatar);

    /**
     * 按用户id逻辑删除一条记录
     * @param userId
     * @return
     */
    int updateUserToDelete(@Param("userId")Long userId);

    //删
    /**
     * （批量）物理删除已逻辑删除的用户记录
     * @return
     */
    int deleteUserDeleted();
}
