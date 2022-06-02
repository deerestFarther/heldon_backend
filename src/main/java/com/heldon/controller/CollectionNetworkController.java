package com.heldon.controller;


import com.heldon.entity.CollectionNetwork;
import com.heldon.service.impl.CollectionNetworkServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (CollectionNetwork)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:25
 */
@RestController
@Api(tags = "CollectionNetwork - 关于收藏关系网该行为的接口")
@RequestMapping("/collectionNetwork")
public class CollectionNetworkController {
    /**
     * 服务对象
     */
    @Autowired
    private CollectionNetworkServiceImpl collectionNetworkService;

    @GetMapping("/get/cns/{collectionId}")
    @ApiOperation("按收藏夹id查找该收藏夹内的全部关系网图")
    public List<CollectionNetwork> getCNByCollectionId(@PathVariable Integer collectionId) {
        Map<String, Object> query = new HashMap<>();
        query.put("collection_id", collectionId);
        return collectionNetworkService.listByMap(query);
    }

    @DeleteMapping("/remove/cn/{containsId}")
    @ApiOperation("在收藏夹中取消收藏某一个关系网")
    public boolean removeCNOne(@PathVariable Integer containsId) {
        return collectionNetworkService.removeById(containsId);
    }

    @PostMapping("/add/cn/{collectionId}&&{netId}")
    @ApiOperation("收藏/喜爱一张关系网")
    public boolean addCNOne(@PathVariable Integer collectionId, @PathVariable Integer netId) {
        CollectionNetwork collectionNetwork = new CollectionNetwork();
        //collectionNetwork.setContainsId(containsId);
        collectionNetwork.setCollectionId(collectionId);
        collectionNetwork.setNetId(netId);
        return collectionNetworkService.saveOrUpdate(collectionNetwork);
    }

}

