package com.heldon.controller;


import com.heldon.DTO.NetworkDTO;
import com.heldon.entity.Network;
import com.heldon.model.TagAdd;
import com.heldon.service.TagService;
import com.heldon.service.impl.NetworkServiceImpl;
import com.heldon.service.impl.UserTagServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Network)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:28
 */
@RestController
@Api(tags = "Network - 关系网管理接口")
@RequestMapping("/network")
public class NetworkController {
    /**
     * 服务对象
     */
    @Autowired
    private NetworkServiceImpl networkService;
    @Autowired
    private UserTagServiceImpl userTagService;

    @PostMapping("/insertNetwork/{netName}/{userId}/{tagId}")
    @ApiOperation("新增一张关系网")
    public Boolean insertOneNetwork(@PathVariable String netName, @PathVariable long userId, @PathVariable int tagId) {
        int netId = networkService.insertOneNetwork(netName, userId);
        TagAdd tagAdd = new TagAdd();
        tagAdd.setTagId(tagId);
        tagAdd.setTagType(1);
        tagAdd.setTargetId(netId);
        return userTagService.saveTag(tagAdd);
    }

    @DeleteMapping("/deleteNetworkByNetId/{netId}")
    @ApiOperation("按netId删除关系网")
    public Boolean deleteNetworkByNetId(@PathVariable int netId) {
        Map<String, Object> map = new HashMap<>();
        map.put("net_id", netId);
        return networkService.removeByMap(map);
    }

    @GetMapping("/updateNetNameByNetId/{netName}/{imgUrl}/{netId}")
    @ApiOperation("修改关系网名称与封面图片")
    public Boolean updateNetworkByNetId(
            @PathVariable String netName, @PathVariable String imgUrl, @PathVariable int netId) {
        Network network = new Network();
        network.setNetId(netId);
        network.setNetName(netName);
        network.setExt3(imgUrl);
        return networkService.updateById(network);
    }


    @GetMapping("/getNetworkByNetId/{netId}")
    @ApiOperation("按netId查找关系网")
    public Network getNetworkByNetId(@PathVariable int netId) {
        Map<String, Object> map = new HashMap<>();
        map.put("net_id", netId);
        return networkService.listByMap(map).get(0);
    }

    @GetMapping("/getNetworkByUserId/{userId}")
    @ApiOperation("按userId查找关系网")
    public List<Network> getNetworkByUserId(@PathVariable long userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        return networkService.listByMap(map);
    }

//    todo 前端请求起来麻烦的话就写
//    @GetMapping("/getNetworkDetailsByNetIdByNetId/{netId}")
//    @ApiOperation("按netId获取关系网详细信息")
//    public List<Network> getNetworkDetailsByNetId(@PathVariable int netId) {
//    }


}

