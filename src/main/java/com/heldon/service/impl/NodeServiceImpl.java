package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.DTO.NodeDTO;
import com.heldon.DTO.NodeXYDTO;
import com.heldon.DTO.UpdateNodeDTO;
import com.heldon.mapper.NodeMapper;
import com.heldon.entity.Node;
import com.heldon.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * (Node)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:29
 */
@Service("nodeService")
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements NodeService {
    @Autowired
    NodeMapper nodeMapper;

    @Override
    public boolean insertOneNode(NodeDTO nodeDTO) {
        Node node = new Node();
        node.setNetId(nodeDTO.getNetId());
        node.setNodeName(nodeDTO.getNodeName());
        node.setId(nodeDTO.getId());
        node.setText(nodeDTO.getText());
        node.setColor(nodeDTO.getColor());
        node.setBorderColor(nodeDTO.getBorderColor());
        node.setFontColor(nodeDTO.getFontColor());
        node.setContent(nodeDTO.getContent());
        node.setUrl(nodeDTO.getUrl());
        Random random = new Random();
        node.setX(random.nextInt(100));
        node.setY(random.nextInt(100));
        return nodeMapper.insert(node) > 0;
    }

    @Transactional
    @Override
    public boolean updateNodeList(List<NodeXYDTO> nodeList) {
        int cnt = 0;//更新的行数
        for (NodeXYDTO nodeXY : nodeList) {
            Node node = new Node();
            node.setNodeId(nodeXY.getNetId());
            node.setX(nodeXY.getX());
            node.setY(nodeXY.getY());
            cnt += nodeMapper.updateById(node);
        }
        return cnt > 0;
    }

    @Override
    public boolean deleteNodeByNodeId(int nodeId) {
        Map<String, Object> del = new HashMap<>();
        del.put("node_id", nodeId);
        return nodeMapper.deleteByMap(del) > 0;
    }

    @Override
    public boolean updateNode(UpdateNodeDTO updateNodeDTO) {
        Node node = new Node();
        node.setNodeId(updateNodeDTO.getNodeId());
        node.setNodeName(updateNodeDTO.getNodeName());
        node.setId(updateNodeDTO.getId());
        node.setText(updateNodeDTO.getText());
        node.setColor(updateNodeDTO.getColor());
        node.setBorderColor(updateNodeDTO.getBorderColor());
        node.setFontColor(updateNodeDTO.getFontColor());
        node.setContent(updateNodeDTO.getContent());
        node.setUrl(updateNodeDTO.getUrl());
        return nodeMapper.updateById(node) > 0;
    }
}

