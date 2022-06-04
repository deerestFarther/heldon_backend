package com.heldon.controller;


import com.heldon.DTO.NodeDTO;
import com.heldon.DTO.NodeXYDTO;
import com.heldon.DTO.UpdateNodeDTO;
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

    @DeleteMapping("/deleteNodeByNodeId/{nodeId}")
    @ApiOperation("按nodeId删除node")
    public boolean deleteNodeByNodeId(@PathVariable int nodeId) {
        return nodeService.deleteNodeByNodeId(nodeId);
    }

    @PutMapping("/updateNode")
    @ApiOperation("更新结点的信息，除了x，y")
    public Boolean updateNode(@RequestBody UpdateNodeDTO updateNodeDTO) {
        return nodeService.updateNode(updateNodeDTO);
    }

    @PutMapping("/updateNodeList")
    @ApiOperation("更新整张图上的所有node的坐标，记录布局信息")
    public Boolean updateNodeList(@RequestBody List<NodeXYDTO> nodeList) {
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

