package com.heldon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Collection;
import com.heldon.entity.CollectionNetwork;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectionNetworkMapper extends BaseMapper<CollectionNetwork> {
    List<CollectionNetwork> checkIfCollected(Integer netId, Integer userId);
}
