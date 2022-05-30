package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.mapper.FondCollectionMapper;
import com.heldon.entity.FondCollection;
import com.heldon.service.FondCollectionService;
import org.springframework.stereotype.Service;

/**
 * (FondCollection)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:27
 */
@Service("fondCollectionService")
public class FondCollectionServiceImpl extends ServiceImpl<FondCollectionMapper, FondCollection> implements FondCollectionService {

}

