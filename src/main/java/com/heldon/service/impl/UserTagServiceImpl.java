package com.heldon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.entity.Tag;
import com.heldon.mapper.TagMapper;
import com.heldon.mapper.UserTagMapper;
import com.heldon.entity.UserTag;
import com.heldon.model.NetTags;
import com.heldon.model.TagAdd;
import com.heldon.service.UserTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * (UserTag)表服务实现类
 *
 * @author hcl
 * @since 2022-05-02 10:54:31
 */
@Service("userTagService")
public class UserTagServiceImpl extends ServiceImpl<UserTagMapper, UserTag> implements UserTagService {

    @Autowired
    UserTagMapper userTagMapper;

    @Autowired
    TagMapper tagMapper;

    public boolean saveTag(TagAdd tagAdd) {
        UserTag userTag = new UserTag().setTagId(tagAdd.getTagId())
                .setTaggingType(tagAdd.getTagType())
                .setTargetId(tagAdd.getTargetId());
        boolean result = save(userTag);
        return result;
    }

    public int deleteTag(int taggingId) {
        int r = userTagMapper.deleteById(taggingId);
        return r;
    }

    @Override
    public List<NetTags> getNetTags(List<Integer> ids) {
        QueryWrapper<UserTag> wrapper = Wrappers.query();
        wrapper.in("target_id", ids);
        List<UserTag> userTagList = userTagMapper.selectList(wrapper);
        int size = userTagList.size();
        List<NetTags> netTagsList = new ArrayList<>();
        Map<Integer, String> tagMap = new HashMap<>();
        if (userTagList.size() != 0) {
            tagMap = tagMapper.selectBatchIds(
                            userTagList.stream().map(UserTag::getTagId).collect(Collectors.toList()))
                    .stream().collect(Collectors.toMap(
                            Tag::getTagId, Tag::getTagName)
                    );
        }
        for (int i = 0; i < size; i++) {
            netTagsList.add(new NetTags().setTaggingId(userTagList.get(i).getTaggingId())
                    .setTagId(userTagList.get(i).getTagId())
                    .setTargetId(userTagList.get(i).getTargetId())
                    .setTagName(tagMap == null ? "没有该标签" : tagMap.get(userTagList.get(i).getTagId())));
        }
        return netTagsList;
    }
}

