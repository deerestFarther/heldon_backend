package com.heldon.controller;


import com.heldon.service.impl.FondCollectionServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (FondCollection)表控制层
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:27
 */
@RestController
@Api(tags = "关于喜爱收藏夹该行为的接口")
@RequestMapping("/fondCollection")
public class FondCollectionController {
    /**
     * 服务对象
     */
    @Autowired
    private FondCollectionServiceImpl fondCollectionService;


}

