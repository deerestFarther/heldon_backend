package com.heldon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heldon.DTO.NodeDTO;
import com.heldon.DTO.NodeXYDTO;
import com.heldon.DTO.UpdateNodeDTO;
import com.heldon.entity.Node;

import java.util.List;

/**
 * (Node)表服务接口
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:29
 */
public interface NodeService extends IService<Node> {
    boolean insertOneNode(NodeDTO nodeDTO);

    boolean updateNodeList(List<NodeXYDTO> nodeList);

    boolean deleteNodeByNodeId(int nodeId);

    boolean updateNode(UpdateNodeDTO updateNodeDTO);
}

