package com.heldon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heldon.entity.UserTag;
import com.heldon.service.UserTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (UserTag)表控制层
 *
 * @author makejava
 * @since 2022-05-02 10:54:31
 */
@RestController
@RequestMapping("userTag")
public class UserTagController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserTagService userTagService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param userTag 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UserTag> page, UserTag userTag) {
        return success(this.userTagService.page(page, new QueryWrapper<>(userTag)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.userTagService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param userTag 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UserTag userTag) {
        return success(this.userTagService.save(userTag));
    }

    /**
     * 修改数据
     *
     * @param userTag 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UserTag userTag) {
        return success(this.userTagService.updateById(userTag));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userTagService.removeByIds(idList));
    }
}

