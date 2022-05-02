package com.heldon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heldon.entity.Network;
import com.heldon.service.NetworkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Network)表控制层
 *
 * @author makejava
 * @since 2022-05-02 10:54:28
 */
@RestController
@RequestMapping("network")
public class NetworkController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private NetworkService networkService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param network 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Network> page, Network network) {
        return success(this.networkService.page(page, new QueryWrapper<>(network)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.networkService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param network 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Network network) {
        return success(this.networkService.save(network));
    }

    /**
     * 修改数据
     *
     * @param network 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Network network) {
        return success(this.networkService.updateById(network));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.networkService.removeByIds(idList));
    }
}

