package com.heldon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heldon.entity.Tag;

import java.util.List;
import java.util.Map;

/**
 * (Tag)表服务接口
 *
 * @author hcl
 * @since 2022-05-02 10:54:30
 */
public interface TagService extends IService<Tag> {

    public List<Tag> getTags();
}

