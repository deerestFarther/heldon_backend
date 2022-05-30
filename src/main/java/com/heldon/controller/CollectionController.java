package com.heldon.controller;


import com.heldon.service.impl.CollectionServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Collection)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:25
 */
@RestController
@Api(tags = "关系网收藏夹管理相关接口")
@RequestMapping("/collection")
public class CollectionController {
    /**
     * 服务对象
     */
     @Autowired
    private CollectionServiceImpl collectionService;


}

