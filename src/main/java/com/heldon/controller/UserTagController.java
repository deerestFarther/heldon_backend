package com.heldon.controller;


import com.heldon.model.NetTags;
import com.heldon.model.TagAdd;
import com.heldon.service.impl.UserTagServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * (UserTag)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:31
 */
@RestController
@Api(tags = "关于贴标签该行为接口（而非贴纸）")
@RequestMapping("/userTag")
public class UserTagController {
    /**
     * 服务对象
     */
    @Autowired
    private UserTagServiceImpl userTagService;

    @PostMapping("/add")
    @ApiOperation("标签添加")
    public boolean tagAdd(@RequestBody TagAdd tagAdd) {
        return userTagService.saveTag(tagAdd);
    }

    @PostMapping("/delete/{taggingId}")
    @ApiOperation("标签删除")
    @ApiImplicitParam(name="taggingId",value = "传入中间表ID",required = true)
    public int tagDelete(@PathVariable int taggingId) {
        return userTagService.deleteTag(taggingId);
    }

    @PostMapping("/get/nettag")
    @ApiOperation("获取关系网标签")
    @ApiImplicitParam(name="targetIds",value = "传入关系网多个ID",required = true)
    public List<NetTags> getNetTags(@RequestBody List<Integer> targetIds)
    {
        return userTagService.getNetTags(targetIds);
    }

   /* @GetMapping("/get/usertag")
    @ApiOperation("获取用户标签")
    public List<UserTags> getUserTags {
        return
    }

    @GetMapping("/get/collectiontag")
    @ApiOperation("获取收藏夹标签")
    public List<CollectionTags> CollectionTags {
        return
    }*/


}

