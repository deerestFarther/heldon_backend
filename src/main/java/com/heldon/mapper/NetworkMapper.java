package com.heldon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heldon.entity.Network;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface NetworkMapper extends BaseMapper<Network> {
    public String getRootIdNameByNetId(int netId);
}
