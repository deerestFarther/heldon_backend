package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.DTO.NodeListDTO;
import com.heldon.DTO.NodeDTO;
import com.heldon.DTO.UpdateNode;
import com.heldon.mapper.NodeMapper;
import com.heldon.entity.Node;
import com.heldon.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        node.setX(nodeDTO.getX());
        node.setY(nodeDTO.getY());
        return nodeMapper.insert(node) > 0;
    }

    @Transactional
    @Override
    public boolean updateNodeList(NodeListDTO nodeList) {
        int cnt = 0;//更新的行数
        for (UpdateNode updateNode : nodeList.getNodeDTOList()) {
            Node node = new Node();
            node.setNodeId(updateNode.getNodeId());
            node.setNetId(nodeList.getNetId());
            node.setNodeName(updateNode.getNodeName());
            node.setId(updateNode.getId());
            node.setText(updateNode.getText());
            node.setColor(updateNode.getColor());
            node.setBorderColor(updateNode.getBorderColor());
            node.setFontColor(updateNode.getFontColor());
            node.setContent(updateNode.getContent());
            node.setX(updateNode.getX());
            node.setY(updateNode.getY());
            node.setUrl(updateNode.getUrl());
            cnt += nodeMapper.updateById(node);
        }
        return cnt > 0;
    }
}

