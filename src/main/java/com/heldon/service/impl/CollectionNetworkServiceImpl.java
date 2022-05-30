package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.mapper.CollectionNetworkMapper;
import com.heldon.entity.CollectionNetwork;
import com.heldon.service.CollectionNetworkService;
import org.springframework.stereotype.Service;

/**
 * (CollectionNetwork)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:26
 */
@Service("collectionNetworkService")
public class CollectionNetworkServiceImpl extends ServiceImpl<CollectionNetworkMapper, CollectionNetwork> implements CollectionNetworkService {

}

