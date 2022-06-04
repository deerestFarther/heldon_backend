package com.heldon.controller;


import com.heldon.DTO.NetworkDTO;
import com.heldon.entity.Network;
import com.heldon.service.impl.NetworkServiceImpl;
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
@Api(tags = "关系网管理接口")
@RequestMapping("/network")
public class NetworkController {
    /**
     * 服务对象
     */
    @Autowired
    private NetworkServiceImpl networkService;

    @PutMapping("/insertNetwork/{netName}/{userId}")
    @ApiOperation("新增一张关系网")
    public Boolean insertOneNetwork(@PathVariable String netName, @PathVariable long userId) {
        return networkService.insertOneNetwork(netName, userId);
    }

    @DeleteMapping("/deleteNetworkByNetId/{netId}")
    @ApiOperation("按netId删除关系网")
    public Boolean deleteNetworkByNetId(@PathVariable int netId) {
        Map<String, Object> map = new HashMap<>();
        map.put("netId", netId);
        return networkService.removeByMap(map);
    }

    @GetMapping("/updateNetNameByNetId/{netName}/{netId}")
    @ApiOperation("修改关系网名称")
    public Boolean deleteNetworkByNetId(@PathVariable String netName, @PathVariable int netId) {
        Map<String, Object> map = new HashMap<>();
        map.put("net_id", netId);
        return networkService.removeByMap(map);
    }


    @GetMapping("/getNetworkByNetId/{netId}")
    @ApiOperation("按netId查找关系网")
    public List<Network> getNetworkByNetId(@PathVariable int netId) {
        Map<String, Object> map = new HashMap<>();
        map.put("net_id", netId);
        return networkService.listByMap(map);
    }

    @GetMapping("/getRootIdNameByNetId/{netId}")
    @ApiOperation("按netId查找关系网的rootIdName")
    public String getRootIdNameByNetId(@PathVariable int netId) {
        return networkService.getRootIdNameByNetId(netId);
    }

//    todo 前端请求起来麻烦的话就写
//    @GetMapping("/getNetworkDetailsByNetIdByNetId/{netId}")
//    @ApiOperation("按netId获取关系网详细信息")
//    public List<Network> getNetworkDetailsByNetId(@PathVariable int netId) {
//    }


}

