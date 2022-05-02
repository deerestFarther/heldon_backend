package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.dao.StickerDao;
import com.heldon.entity.Sticker;
import com.heldon.service.StickerService;
import org.springframework.stereotype.Service;

/**
 * (Sticker)表服务实现类
 *
 * @author makejava
 * @since 2022-05-02 10:54:30
 */
@Service("stickerService")
public class StickerServiceImpl extends ServiceImpl<StickerDao, Sticker> implements StickerService {

}

