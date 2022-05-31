package com.heldon.controller;


import com.heldon.entity.Collection;
import com.heldon.service.impl.CollectionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add/collection/{collectionName}&&{userId}")
    @ApiOperation("新建收藏夹")
    public boolean addCollectionOne(@PathVariable String collectionName,@PathVariable Long userId){
        Collection collection = new Collection();
        collection.setCollectionName(collectionName);
        collection.setUserId(userId);
        return collectionService.save(collection);
    }

    @PutMapping("renew/collection/{collectionName}")
    @ApiOperation("更新收藏夹为官方（公开）收藏夹")
    public int renewCollectionOne(@PathVariable String collectionName){
        //collectionService.updateById()
        return 0;
    }
}

