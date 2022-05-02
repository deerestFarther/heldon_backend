package com.heldon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Sticker;

/**
 * (Sticker)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 10:54:30
 */
public interface StickerDao extends BaseMapper<Sticker> {

    int insert(Sticker record);

    int insertSelective(Sticker record);

    int update(Sticker record);

    int updateSelective(Sticker record);

    Sticker queryOne(Integer stickerId);

    int delete(Integer stickerId);
}

