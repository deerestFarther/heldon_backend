package com.heldon.controller;


import com.heldon.entity.Authorization;
import com.heldon.service.impl.AuthorizationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api(tags = "用户登录授权相关接口")
@RequestMapping("/authorization")
public class AuthorizationController  {
    /**
     * 服务对象
     */
    @Autowired
    private AuthorizationServiceImpl authorizationService;

    @GetMapping("/getAuthorizationByUserId/{userId}")
    @ApiOperation("按userId查找该用户的授权信息")
    public List<Authorization> getAuthorizationByUserId(@PathVariable Long userId){
        Map<String,Object> query = new HashMap<>();
        query.put("user_id",userId);
        List<Authorization> result = authorizationService.listByMap(query);
        return result;
    }
}

