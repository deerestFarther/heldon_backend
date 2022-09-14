package com.heldon.controller;


import com.heldon.DTO.NetworkAdd;
import com.heldon.DTO.NetworkDTO;
import com.heldon.DTO.NetworkMsg;
import com.heldon.entity.Network;
import com.heldon.entity.UserTag;
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

    @PostMapping("/insertNetwork/")
    @ApiOperation("新增一张关系网")
    public Boolean insertOneNetwork(@RequestBody NetworkAdd networkAdd) {
        int netId = networkService.insertOneNetwork(
                networkAdd.getNetName(), networkAdd.getUrl(), networkAdd.getUserId());
        TagAdd tagAdd = new TagAdd();
        tagAdd.setTagId(networkAdd.getTagId());
        tagAdd.setTagType(1);
        tagAdd.setTargetId(netId);
        return userTagService.saveTag(tagAdd);
    }

    @DeleteMapping("/deleteNetworkByNetId/{netId}")
    @ApiOperation("按netId删除关系网")
    public Boolean deleteNetworkByNetId(@PathVariable int netId) {
        // 从标签表逻辑删除掉有关这张关系网的信息
        Map<String, Object> mapUserTag = new HashMap<>();
        mapUserTag.put("target_id", netId); // 查到这条待删除的关系网的记录
        int taggingId = userTagService.listByMap(mapUserTag).get(0).getTaggingId(); // 该记录的主键id
        userTagService.removeById(taggingId); // 进行逻辑删除
        // 从关系网表物理删除掉这张关系网
        Map<String, Object> map = new HashMap<>();
        map.put("net_id", netId);
        return networkService.removeByMap(map);
    }

    @PutMapping("/updateNetNameByNetId/")
    @ApiOperation("修改关系网名称与封面图片")
    public Boolean updateNetworkByNetId(@RequestBody NetworkMsg networkMsg) {
        Network network = new Network();
        network.setNetId(networkMsg.getNetId());
        network.setNetName(networkMsg.getNetName());
        network.setExt3(networkMsg.getUrl());
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

