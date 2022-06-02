package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.DTO.NetworkDTO;
import com.heldon.mapper.NetworkMapper;
import com.heldon.entity.Network;
import com.heldon.service.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Network)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:28
 */
@Service("networkService")
public class NetworkServiceImpl extends ServiceImpl<NetworkMapper, Network> implements NetworkService {
    @Autowired
    NetworkMapper mapper;

    @Override
    public boolean insertOneNetwork(String netName, Long userId) {
        Network net = new Network();
        net.setNetName(netName);
        net.setUserId(userId);
        net.setRootNodeId(0);
        net.setCommentCount(0);
        return mapper.insert(net) > 0;
    }

    @Override
    public String getRootIdNameByNetId(int netId) {
        return mapper.getRootIdNameByNetId(netId);
    }
}

