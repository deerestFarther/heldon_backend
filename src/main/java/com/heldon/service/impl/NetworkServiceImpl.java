package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.dao.NetworkDao;
import com.heldon.entity.Network;
import com.heldon.service.NetworkService;
import org.springframework.stereotype.Service;

/**
 * (Network)表服务实现类
 *
 * @author makejava
 * @since 2022-05-02 10:54:28
 */
@Service("networkService")
public class NetworkServiceImpl extends ServiceImpl<NetworkDao, Network> implements NetworkService {

}

