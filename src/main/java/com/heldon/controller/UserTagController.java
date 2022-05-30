package com.heldon.controller;


import com.heldon.service.impl.UserTagServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (UserTag)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:31
 */
@RestController
@Api(tags = "关于贴标签该行为接口（而非贴纸）")
@RequestMapping("/userTag")
public class UserTagController {
    /**
     * 服务对象
     */
    @Autowired
    private UserTagServiceImpl userTagService;


}

