package com.heldon.controller;


import com.heldon.service.impl.StickerServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Sticker)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:30
 */
@RestController
@Api(tags = "贴纸管理接口")
@RequestMapping("/sticker")
public class StickerController {
    /**
     * 服务对象
     */
    @Autowired
    private StickerServiceImpl stickerService;


}

