package com.heldon.service;

import com.heldon.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserServiceTestor {
    @Autowired
    private UserService userService;

    @Test
    public void testSaveBatch(){//批量添加的方法如果写在mapper里会使得sql语句又臭又长，所以放在service这里，用saveBatch接口调用
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setNickname("hanbaba"+"000"+i);
            user.setAvatar("avatar" + i);
            Date date = new Date();
            user.setCreateTime(date);
            list.add(user);
        }
        boolean result = userService.saveBatch(list);
        System.out.println(result);
    }
}
