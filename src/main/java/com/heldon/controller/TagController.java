package com.heldon.controller;


import com.heldon.entity.Tag;
import com.heldon.service.impl.TagServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Tag)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:30
 */
@RestController
@Api(tags = "标签管理接口")
@RequestMapping("/tag")
public class TagController {
    /**
     * 服务对象
     */
    @Autowired
    private TagServiceImpl tagService;

}

