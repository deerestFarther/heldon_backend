package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.dao.TagDao;
import com.heldon.entity.Tag;
import com.heldon.service.TagService;
import org.springframework.stereotype.Service;

/**
 * (Tag)表服务实现类
 *
 * @author makejava
 * @since 2022-05-02 10:54:30
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements TagService {

}

