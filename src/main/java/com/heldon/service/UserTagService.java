package com.heldon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heldon.entity.UserTag;
import com.heldon.model.NetTags;
import com.heldon.model.TagAdd;

import java.util.List;
import java.util.Set;

/**
 * (UserTag)表服务接口
 *
 * @author hcl
 * @since 2022-05-02 10:54:31
 */
public interface UserTagService extends IService<UserTag> {
    public boolean saveTag(TagAdd tagAdd);

    public int deleteTag(int taggingId);

    public List<NetTags> getNetTags(List<Integer> ids);

    public List<Integer> getNetByTag(String tagId);
}

