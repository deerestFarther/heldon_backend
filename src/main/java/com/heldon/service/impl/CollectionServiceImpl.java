package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.mapper.CollectionMapper;
import com.heldon.entity.Collection;
import com.heldon.service.CollectionService;
import org.springframework.stereotype.Service;

/**
 * (Collection)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:25
 */
@Service("collectionService")
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {

}

