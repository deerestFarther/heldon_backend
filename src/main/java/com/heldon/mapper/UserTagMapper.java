package com.heldon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.User;
import com.heldon.entity.UserTag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTagMapper extends BaseMapper<UserTag> {
}
