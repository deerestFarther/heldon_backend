package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.entity.Collection;
import com.heldon.mapper.CollectionMapper;
import com.heldon.mapper.CollectionNetworkMapper;
import com.heldon.entity.CollectionNetwork;
import com.heldon.service.CollectionNetworkService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (CollectionNetwork)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:26
 */
@Service("collectionNetworkService")
public class CollectionNetworkServiceImpl extends ServiceImpl<CollectionNetworkMapper, CollectionNetwork> implements CollectionNetworkService {
    @Autowired
    CollectionNetworkMapper mapper;

    @Override
    public Boolean checkIfCollected(Integer netId, Integer userId) {
        List<CollectionNetwork> list = mapper.checkIfCollected(netId, userId);
        return list != null && list.size() > 0;
    }
}

