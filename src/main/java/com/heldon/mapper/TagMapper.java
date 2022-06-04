package com.heldon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    @Select("select * from tag ORDER BY create_time DESC")
    public List<Tag> selectTags();
}
