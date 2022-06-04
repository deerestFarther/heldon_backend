package com.heldon.controller;


import com.heldon.entity.Authorization;
import com.heldon.entity.User;
import com.heldon.service.UserService;
import com.heldon.service.impl.AuthorizationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Authorization)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:24
 */
@RestController
@Api(tags = "Authorization - 用户登录授权相关接口")
@RequestMapping("/authorization")
public class AuthorizationController {
    /**
     * 服务对象
     */
    @Autowired
    private AuthorizationServiceImpl authorizationService;

    @Autowired
    private UserService userService;

    @GetMapping("/exists/authorization/{identifier}")
    @ApiOperation("确认某个唯一标识没有被注册（绑定）过，用于注册表单异步验证")
    public boolean isAuthorizied(@PathVariable String identifier) {
        return (getUserIdByIdentifier(identifier) != null);
    }

    @GetMapping("/get/authorizations/{userId}")
    @ApiOperation("按userId查找该用户的授权信息")
    public List<Authorization> getAuthorizationByUserId(@PathVariable Long userId) {
        Map<String, Object> query = new HashMap<>();
        query.put("user_id", userId);
        List<Authorization> result = authorizationService.listByMap(query);
        return result;
    }

    @PostMapping("/get/authorization/{identifier}")
    @ApiOperation("按登录标识查询用户id")
    public Long getUserIdByIdentifier(@PathVariable String identifier) {
        Map<String, Object> query = new HashMap<>();
        query.put("identifier", identifier);
        List<Authorization> authorizations = authorizationService.listByMap(query);
        if (authorizations.size() == 1) return authorizations.get(0).getUserId();
        return null;
    }

    @PutMapping("/renew/authorization/{userId}&&{authId}&&{identifierType}&&{identifier}&&{credentials}")
    @ApiOperation("更新登录标识")
    public boolean renewAuthorizationOne(@PathVariable Long userId, @PathVariable Integer authId,
                                         @PathVariable Integer identityType,
                                         @PathVariable String identifier,
                                         @PathVariable String credentials) {
        Authorization authorization = new Authorization();
        authorization.setAuthId(authId);
        authorization.setUserId(userId);
        authorization.setIdentityType(identityType);
        authorization.setIdentifier(identifier);
        authorization.setCredentials(credentials);
        authorization.setLastloginTime(new Date());
        return authorizationService.updateById(authorization);
    }

    @DeleteMapping("/remove/authorization/{authId}")
    @ApiOperation("按授权信息的id（逻辑）删除授权信息（单条）")
    public boolean removeAuthorizationOne(@PathVariable Integer authId) {
        return authorizationService.removeById(authId);
    }

    //写插入的时候考虑一下如何保证每次更新时createtime如何不自动更改
    ////1、可以后端改掉currenttimemillis，这样在创建的时候手动生成一下（不太妙）
    //todo 2、或者直接把这个字段放在User表里，在注册用户时就记录一下时间，其他情况就相当于是Authorization代表登录记录一样
    ////也就是这边的controller还要用一下user的mapper在第一次注册的时候要新建用户（checked），可能效果并不如前端仍两次请求好
    @PostMapping("/add/authorization/new/{identityType}&&{identifier}&&{credentials}")
    @ApiOperation("注册新用户")
    public boolean addAuthorizationNew(@PathVariable Integer identityType,
                                       @PathVariable String identifier,
                                       @PathVariable String credentials) {
        Authorization authorization = new Authorization();
        //使用userService先新增一个新用户（todo接口保证传过来的一定是唯一的）
        userService.insertUser(identifier);
        Map<String, Object> query = new HashMap<>();
        query.put("nickname", identifier);
        List<User> newUser = userService.listByMap(query);//拿到这个用户的信息
        Long userId = newUser.get(0).getUserId();//拿到这个用户的id

        authorization.setUserId(userId);
        authorization.setIdentityType(identityType);
        authorization.setIdentifier(identifier);
        authorization.setCredentials(credentials);
        return authorizationService.save(authorization);
    }

    @PostMapping("/add/authorization/{userId}&&{identityType}&&{identifier}&&{credentials}")
    @ApiOperation("添加新的绑定（授权）")
    public boolean addAuthorizationOne(@PathVariable Long userId,
                                       @PathVariable Integer identityType,
                                       @PathVariable String identifier,
                                       @PathVariable String credentials) {
        Authorization authorization = new Authorization();
        authorization.setUserId(userId);
        authorization.setIdentityType(identityType);
        authorization.setIdentifier(identifier);
        authorization.setCredentials(credentials);
        return authorizationService.save(authorization);
    }

    @PostMapping("/validate/authorization/{identifier}&&{credential}")
    @ApiOperation("登录验证")
    public Long validateAuthoriztion(@PathVariable String identifier, @PathVariable String credential) {
        Map<String, Object> query = new HashMap<>();
        query.put("identifier", identifier);
        query.put("credentials", credential);
        List<Authorization> rlt = authorizationService.listByMap(query);
        if (rlt.size() != 0) return rlt.get(0).getUserId();
        return null;
    }
}

