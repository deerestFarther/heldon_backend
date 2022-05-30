package com.heldon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heldon.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User> {

    User selectUserByUserId(Long userId);

    List<User> selectUserByNickname(String nickname);

    int insertUser(String nickname);
}
