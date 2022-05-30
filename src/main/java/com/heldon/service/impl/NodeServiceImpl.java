package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.mapper.NodeMapper;
import com.heldon.entity.Node;
import com.heldon.service.NodeService;
import org.springframework.stereotype.Service;

/**
 * (Node)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:29
 */
@Service("nodeService")
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements NodeService {

}

