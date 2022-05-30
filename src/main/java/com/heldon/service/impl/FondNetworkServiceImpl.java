package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.mapper.FondNetworkMapper;
import com.heldon.entity.FondNetwork;
import com.heldon.service.FondNetworkService;
import org.springframework.stereotype.Service;

/**
 * (FondNetwork)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:28
 */
@Service("fondNetworkService")
public class FondNetworkServiceImpl extends ServiceImpl<FondNetworkMapper, FondNetwork> implements FondNetworkService {

}

