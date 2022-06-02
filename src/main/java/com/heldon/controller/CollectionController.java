package com.heldon.controller;


import com.heldon.entity.Collection;
import com.heldon.service.impl.CollectionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Collection)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:25
 */
@RestController
@Api(tags = "Collection - 关系网收藏夹管理相关接口")
@RequestMapping("/collection")
public class CollectionController {
    /**
     * 服务对象
     */
    @Autowired
    private CollectionServiceImpl collectionService;

    @GetMapping("/get/collection/id/{userId}")
    @ApiOperation("按用户id查找该用户的喜爱收藏夹id")
    public Integer getCollectionLikeByUserId(@PathVariable Long userId) {
        Map<String, Object> query = new HashMap<>();
        query.put("user_id", userId);
        query.put("collection_type", 1);
        List<Collection> collections = collectionService.listByMap(query);
        if (collections.size() == 1) return collections.get(0).getCollectionId();
        return null;
    }

    @GetMapping("/get/collection/{collectionId}")
    @ApiOperation("查找某一个收藏夹的信息（名称、简介）")
    public List<Collection> getCollectionByCollectionId(@PathVariable Integer collectionId) {
        Map<String, Object> query = new HashMap<>();
        query.put("collection_id", collectionId);
        return collectionService.listByMap(query);
    }

    @GetMapping("/get/collections/{userId}")
    @ApiOperation("查找当前用户所有的收藏夹")
    public List<Collection> getCollectionsByUserId(@PathVariable Long userId) {
        Map<String, Object> query = new HashMap<>();
        query.put("user_id", userId);
        return collectionService.listByMap(query);
    }

    @PutMapping("/renew/collection/content/{userId}&&{collectionId}&&{content}")
    @ApiOperation("更新收藏夹简介")
    public boolean renewCollectionOne(@PathVariable Long userId, @PathVariable Integer collectionId, @PathVariable String content) {
        Collection collection = new Collection();
        collection.setCollectionId(collectionId);
        collection.setContent(content);
        return collectionService.updateById(collection);
    }

    @PutMapping("/renew/collection/name/{userId}&&{collectionId}&&{collectionNameOld}&&{collectionNameNew}")
    @ApiOperation("更新收藏夹名字")
    public boolean renewCollectionOne(@PathVariable Long userId, @PathVariable Integer collectionId, @PathVariable String collectionNameOld, @PathVariable String collectionNameNew) {
        Collection collection = new Collection();
        collection.setCollectionId(collectionId);
        collection.setCollectionName(collectionNameNew);
        return collectionService.updateById(collection);
    }

    @DeleteMapping("/remove/collection/{collectionId}")
    @ApiOperation("按收藏夹id（逻辑）删除收藏夹（单条）")
    public boolean removeCollectionOne(@PathVariable Integer collectionId) {
        return collectionService.removeById(collectionId);
    }

    @PostMapping("/add/collection/{collectionName}&&{userId}&&{content}")
    @ApiOperation("新建收藏夹")
    public boolean addCollectionOne(@PathVariable String collectionName, @PathVariable Long userId, @PathVariable String content) {
        Collection collection = new Collection();
        collection.setCollectionName(collectionName);
        collection.setUserId(userId);
        collection.setContent(content);
        return collectionService.save(collection);
    }
}

