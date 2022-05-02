package com.heldon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heldon.entity.Sticker;
import com.heldon.service.StickerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Sticker)表控制层
 *
 * @author makejava
 * @since 2022-05-02 10:54:30
 */
@RestController
@RequestMapping("sticker")
public class StickerController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private StickerService stickerService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sticker 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Sticker> page, Sticker sticker) {
        return success(this.stickerService.page(page, new QueryWrapper<>(sticker)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.stickerService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sticker 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Sticker sticker) {
        return success(this.stickerService.save(sticker));
    }

    /**
     * 修改数据
     *
     * @param sticker 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Sticker sticker) {
        return success(this.stickerService.updateById(sticker));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.stickerService.removeByIds(idList));
    }
}

