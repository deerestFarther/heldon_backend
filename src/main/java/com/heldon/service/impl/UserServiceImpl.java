package com.heldon.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.entity.User;
import com.heldon.entity.UserTag;
import com.heldon.mapper.UserMapper;
import com.heldon.model.UserChange;
import com.heldon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserByUserId(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public List<User> selectUserByNickname(String nickname) {
        Map<String, Object> query = new HashMap<>();
        query.put("nickname", nickname);
        return userMapper.selectByMap(query);
    }

    @Override
    public int insertUser(String nickname) {
        User user = new User();
        user.setAvatar("avatar");
        user.setNickname(nickname);
        user.setCreateTime(new Date());
        //todo 还有创建关于该用户的一个喜爱收藏夹
        return userMapper.insert(user);
    }

    @Override
    public String editUser(UserChange userChange) {
        String nickName;
        String msg;
        User user=userMapper.selectUserByUserId(userChange.getUserId()).get(0);
        if (userChange.getNickname() != null) {
            nickName = userChange.getNickname();
            QueryWrapper<User> wrapper = Wrappers.query();
            wrapper.eq("nickname", nickName);
            List<User> userList = userMapper.selectList(wrapper);
            if (userList.size() != 0) {
                msg = "该用户名已存在";
                return msg;
            }
            else{
                user.setNickname(nickName);
            }
        }
        if(userChange.getAvatar()!=null){
            user.setAvatar(userChange.getAvatar());
        }
        if (userChange.getExt3()!=null){//修改简介
            user.setExt3(userChange.getExt3());
        }
        userMapper.updateById(user);
        return "修改成功";
    }

}
