package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.DTO.NewRelationDTO;
import com.heldon.DTO.RelationDTO;
import com.heldon.mapper.RelationMapper;
import com.heldon.entity.Relation;
import com.heldon.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Relation)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:29
 */
@Service("relationService")
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements RelationService {
    @Autowired
    RelationMapper mapper;

    @Override
    public List<Relation> getRelationListByNetId(int netId) {
        return mapper.selectRelationListByNetId(netId);
    }

    @Override
    public Boolean updateRelation(RelationDTO relationDTO) {
        Relation relation = new Relation();
        relation.setEdgeId(relationDTO.getEdgeId());
        relation.setFontColor(relationDTO.getFontColor());
        relation.setLineShape(relationDTO.getLineShape());
        relation.setText(relationDTO.getText());
        relation.setLineWidth(relationDTO.getLineWidth());
        relation.setColor(relationDTO.getColor());
        relation.setEdgeName(relationDTO.getEdgeName());
        relation.setContent(relationDTO.getContent());
        return mapper.updateById(relation) > 0;
    }

    @Override
    public Boolean insertRelation(NewRelationDTO newRelationDTO) {
        Relation relation = new Relation();
        relation.setNodeIdFrom(newRelationDTO.getFrom());
        relation.setNodeIdTo(newRelationDTO.getTo());
        relation.setFontColor(newRelationDTO.getFontColor());
        relation.setLineShape(newRelationDTO.getLineShape());
        relation.setText(newRelationDTO.getText());
        relation.setLineWidth(newRelationDTO.getLineWidth());
        relation.setColor(newRelationDTO.getColor());
        relation.setEdgeName(newRelationDTO.getEdgeName());
        relation.setContent(newRelationDTO.getContent());
        mapper.insert(relation);
        return relation.getEdgeId() > 0;
    }

    @Override
    public Boolean deleteRelationByEdgeId(int edgeId) {
        Map<String, Object> del = new HashMap<>();
        del.put("edge_id", edgeId);
        return mapper.deleteByMap(del) > 0;
    }
}

