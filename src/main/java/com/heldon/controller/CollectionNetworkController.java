package com.heldon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heldon.entity.CollectionNetwork;
import com.heldon.service.CollectionNetworkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (CollectionNetwork)表控制层
 *
 * @author makejava
 * @since 2022-05-02 10:54:25
 */
@RestController
@RequestMapping("collectionNetwork")
public class CollectionNetworkController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CollectionNetworkService collectionNetworkService;

    /**
     * 分页查询所有数据
     *
     * @param page              分页对象
     * @param collectionNetwork 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CollectionNetwork> page, CollectionNetwork collectionNetwork) {
        return success(this.collectionNetworkService.page(page, new QueryWrapper<>(collectionNetwork)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.collectionNetworkService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param collectionNetwork 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CollectionNetwork collectionNetwork) {
        return success(this.collectionNetworkService.save(collectionNetwork));
    }

    /**
     * 修改数据
     *
     * @param collectionNetwork 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CollectionNetwork collectionNetwork) {
        return success(this.collectionNetworkService.updateById(collectionNetwork));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.collectionNetworkService.removeByIds(idList));
    }
}

