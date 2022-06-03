package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.mapper.TagMapper;
import com.heldon.entity.Tag;
import com.heldon.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Tag)表服务实现类
 *
 * @author hcl
 * @since 2022-05-02 10:54:30
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> getTags() {
        return tagMapper.selectTags();
    }
}

