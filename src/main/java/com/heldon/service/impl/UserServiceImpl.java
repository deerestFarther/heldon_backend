package com.heldon.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.entity.User;
import com.heldon.mapper.UserMapper;
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
        Map<String,Object> query = new HashMap<>();
        query.put("nickname",nickname);
        return userMapper.selectByMap(query);
    }

    @Override
    public int insertUser(String nickname) {
        User user = new User();
        user.setAvatar("avatar");
        user.setNickname(nickname);
        user.setCreateTime(new Date());
        return userMapper.insert(user);
    }
}
