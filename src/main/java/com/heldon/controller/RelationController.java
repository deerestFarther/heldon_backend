package com.heldon.controller;


import com.heldon.service.impl.RelationServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

