package com.heldon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heldon.entity.Node;
import com.heldon.service.NodeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Node)表控制层
 *
 * @author makejava
 * @since 2022-05-02 10:54:29
 */
@RestController
@RequestMapping("node")
public class NodeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private NodeService nodeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param node 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Node> page, Node node) {
        return success(this.nodeService.page(page, new QueryWrapper<>(node)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.nodeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param node 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Node node) {
        return success(this.nodeService.save(node));
    }

    /**
     * 修改数据
     *
     * @param node 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Node node) {
        return success(this.nodeService.updateById(node));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.nodeService.removeByIds(idList));
    }
}

