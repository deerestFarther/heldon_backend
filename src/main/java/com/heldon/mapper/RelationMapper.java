package com.heldon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Relation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RelationMapper extends BaseMapper<Relation> {
    List<Relation> selectRelationListByNetId(int netId);
}
