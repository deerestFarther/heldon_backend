package com.heldon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heldon.DTO.NewRelationDTO;
import com.heldon.DTO.RelationDTO;
import com.heldon.entity.Relation;

import java.util.List;

/**
 * (Relation)表服务接口
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:29
 */
public interface RelationService extends IService<Relation> {
    List<Relation> getRelationListByNetId(int netId);

    Boolean updateRelation(RelationDTO relationDTO);

    Boolean insertRelation(NewRelationDTO newRelationDTO);

    Boolean deleteRelationByEdgeId(int edgeId);
}

