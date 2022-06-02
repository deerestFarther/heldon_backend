package com.heldon.controller;


import com.heldon.DTO.RelationDTO;
import com.heldon.entity.Relation;
import com.heldon.service.impl.RelationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Relation)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:29
 */
@RestController
@Api(tags = "关系网边管理接口")
@RequestMapping("/relation")
public class RelationController {
    /**
     * 服务对象
     */
    @Autowired
    private RelationServiceImpl relationService;

    @GetMapping("/insertRelation")
    @ApiOperation("新增一条边")
    public Boolean insertRelation(@RequestBody RelationDTO relationDTO) {
        return false;
    }

    @GetMapping("/deleteRelationByEdgeId")
    @ApiOperation("删除一条边")
    public Boolean deleteRelationByEdgeId(int edgeId) {
        Map<String, Object> del = new HashMap<>();
        del.put("edge_id", edgeId);
        return relationService.removeByMap(del);
    }

    @GetMapping("/updateRelation")
    @ApiOperation("更新一条边")
    public Boolean updateRelation(@RequestBody RelationDTO relationDTO) {
        return false;
    }

    @GetMapping("/getRelationListByNetId/{netId}")
    @ApiOperation("根据netId查询边")
    public List<Relation> getRelationListByNetId(@PathVariable int netId) {
        return relationService.getRelationListByNetId(netId);
    }


}

