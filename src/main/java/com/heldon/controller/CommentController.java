package com.heldon.controller;


import com.heldon.service.impl.CommentServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Comment)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:26
 */
@RestController
@Api(tags = "用户评论相关接口")
@RequestMapping("/comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Autowired
    private CommentServiceImpl commentService;


}

