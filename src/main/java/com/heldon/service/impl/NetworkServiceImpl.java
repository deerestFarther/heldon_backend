package com.heldon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.DTO.NetworkDTO;
import com.heldon.DTO.NodeDTO;
import com.heldon.entity.Node;
import com.heldon.mapper.NetworkMapper;
import com.heldon.entity.Network;
import com.heldon.service.NetworkService;
import com.heldon.service.NodeService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

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

    @Autowired
    NodeService nodeService;

    @Override
    public Integer insertOneNetwork(String netName, Long userId) {
        Network net = new Network();
        net.setNetName(netName);
        net.setUserId(userId);
        net.setRootNodeId(0);
        net.setCommentCount(0);
        mapper.insert(net);

        //在新建好的net中插入一个结点作为根结点
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setNetId(net.getNetId());
        nodeDTO.setNodeName(netName);
        nodeDTO.setText(netName);
        nodeDTO.setId(netName);
        nodeDTO.setContent("");
        nodeDTO.setFontColor("#111111");
        nodeDTO.setColor("#aaaaaa");
        nodeDTO.setBorderColor("#7f7f7f");
        nodeDTO.setUrl("https://relation-network.oss-cn-chengdu.aliyuncs.com/pictures/default.jpg");
        nodeService.insertOneNode(nodeDTO);

        //找到新建的结点
        QueryWrapper<Node> wrapper = new QueryWrapper<>();
        wrapper.eq("net_id", net.getNetId());
        List<Node> nodeList = nodeService.list(wrapper);
        Node node = nodeList.get(0);            //肯定有且仅有一个
        net.setRootNodeId(node.getNodeId());

        mapper.updateById(net);
        return net.getNetId();
    }

}

