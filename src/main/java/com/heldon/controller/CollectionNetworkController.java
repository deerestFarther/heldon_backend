package com.heldon.controller;


import com.heldon.service.impl.CollectionNetworkServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (CollectionNetwork)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:25
 */
@RestController
@Api(tags = "关于收藏关系网该行为的接口")
@RequestMapping("/collectionNetwork")
public class CollectionNetworkController  {
    /**
     * 服务对象
     */
     @Autowired
    private CollectionNetworkServiceImpl collectionNetworkService;

   
}

