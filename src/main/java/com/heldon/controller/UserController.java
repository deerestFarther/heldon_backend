package com.heldon.controller;

import com.heldon.entity.User;
import com.heldon.model.Response;
import com.heldon.model.UserChange;
import com.heldon.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "User - 用户账号相关接口")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getInfoByUserId/{userId}")
    @ApiOperation("按userId查找用户信息")
    public User getInfoByUserId(@PathVariable Long userId){
        User userInfo = userService.selectUserByUserId(userId);
        return userInfo;
    }


    @GetMapping("/getInfoByNickname/{nickname}")
    @ApiOperation("按用户昵称查找用户信息")
    public List<User> getInfoByNickname(@PathVariable String nickname){
        List<User> userInfo = userService.selectUserByNickname(nickname);
        return userInfo;
    }

    @GetMapping("/addUser/{nickname}")
    @ApiOperation("新增用户信息")
    public int addUser(@PathVariable String nickname){
        int rlt = userService.insertUser(nickname);
        return rlt;
    }

    @PostMapping("/edit")
    @ApiOperation("修改用户信息")
    public Response<Void> addUser(@RequestBody UserChange userChange){
        return Response.okMsg(userService.editUser(userChange));
    }
}
