package com.heldon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heldon.entity.Relation;
import com.heldon.service.RelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Relation)表控制层
 *
 * @author makejava
 * @since 2022-05-02 10:54:29
 */
@RestController
@RequestMapping("relation")
public class RelationController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private RelationService relationService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param relation 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Relation> page, Relation relation) {
        return success(this.relationService.page(page, new QueryWrapper<>(relation)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.relationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param relation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Relation relation) {
        return success(this.relationService.save(relation));
    }

    /**
     * 修改数据
     *
     * @param relation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Relation relation) {
        return success(this.relationService.updateById(relation));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.relationService.removeByIds(idList));
    }
}

