package com.heldon.controller;


import com.heldon.entity.Sticker;
import com.heldon.service.impl.StickerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Sticker)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:30
 */
@RestController
@Api(tags = "Sticker - 贴纸管理接口")
@RequestMapping("/sticker")
public class StickerController {
    /**
     * 服务对象
     */
    @Autowired
    private StickerServiceImpl stickerService;

    @GetMapping("/get/stickers/{targetType}&&{targetId}")
    @ApiOperation("按贴纸目标id查找所有一级贴纸")
    public List<Sticker> getStickersByTargetId(@PathVariable Integer targetType, @PathVariable Integer targetId) {
        Map<String, Object> query = new HashMap<>();
        query.put("target_id", targetId);
        query.put("target_type", targetType);
        return stickerService.listByMap(query);
    }

    @GetMapping("/get/stickers/{targetId}")
    @ApiOperation("按一级贴纸id查找二级贴纸")
    public List<Sticker> getStickersLevel2ByTargetId(@PathVariable Integer targetId) {
        Map<String, Object> query = new HashMap<>();
        query.put("target_id", targetId);
        query.put("target_type", 2);
        return stickerService.listByMap(query);
    }

    @DeleteMapping("/remove/sticker/{stickerId}")
    @ApiOperation("按贴纸id（逻辑）删除贴纸（单条）")
    public boolean removeStickerOne(@PathVariable Integer stickerId) {
        return stickerService.removeById(stickerId);
    }

    @PostMapping("/add/Sticker/{userId}&&{targetId}&&{targetType}&&{comment}")
    @ApiOperation("添加贴纸")
    public boolean addStickerOne(@PathVariable Long userId, @PathVariable Integer targetType, @PathVariable Integer targetId, @PathVariable String comment) {
        Sticker sticker = new Sticker();
        sticker.setUserId(userId);
        sticker.setTargetId(targetId);
        sticker.setTargetType(targetType);
        sticker.setContent(comment);
        return stickerService.save(sticker);
    }
}

