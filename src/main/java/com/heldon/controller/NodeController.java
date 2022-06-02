package com.heldon.controller;


import com.heldon.DTO.NodeListDTO;
import com.heldon.DTO.NodeDTO;
import com.heldon.entity.Node;
import com.heldon.service.impl.NodeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Node)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:29
 */
@RestController
@Api(tags = "关系网结点管理接口")
@RequestMapping("/node")
public class NodeController {
    /**
     * 服务对象
     */
    @Autowired
    private NodeServiceImpl nodeService;

    @PostMapping("/insertOneNode")
    @ApiOperation("插入一个node")
    public Boolean insertNode(@RequestBody NodeDTO nodeDTO) {
        return nodeService.insertOneNode(nodeDTO);
    }

    @GetMapping("/deleteNodeByNodeId/{nodeId}")
    @ApiOperation("按nodeId删除node")
    public boolean deleteNodeByNodeId(@PathVariable int nodeId) {
        Map<String, Object> del = new HashMap<>();
        del.put("node_id", nodeId);
        return nodeService.removeByMap(del);
    }

    @PostMapping("/updateNodeList")
    @ApiOperation("更新整张图上的所有node")
    public Boolean updateNodeList(@RequestBody NodeListDTO nodeList) {
        return nodeService.updateNodeList(nodeList);
    }

    @GetMapping("/getNodeByNodeId/{nodeId}")
    @ApiOperation("按nodeId查询node")
    public List<Node> getNodeByNodeId(@PathVariable int nodeId) {
        Map<String, Object> query = new HashMap<>();
        query.put("node_id", nodeId);
        return nodeService.listByMap(query);
    }

    @GetMapping("/getNodeListByNetId/{netId}")
    @ApiOperation("按netId查询node")
    public List<Node> getNodeListByNetId(@PathVariable int netId) {
        Map<String, Object> query = new HashMap<>();
        query.put("net_id", netId);
        return nodeService.listByMap(query);
    }
}

