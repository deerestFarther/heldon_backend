package com.heldon.controller;


import com.heldon.service.impl.FondNetworkServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (FondNetwork)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:28
 */
@RestController
@Api(tags = "关于喜爱关系网该行为的接口")
@RequestMapping("/fondNetwork")
public class FondNetworkController {
    /**
     * 服务对象
     */
    @Autowired
    private FondNetworkServiceImpl fondNetworkService;


}

