package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.mapper.RelationMapper;
import com.heldon.entity.Relation;
import com.heldon.service.RelationService;
import org.springframework.stereotype.Service;

/**
 * (Relation)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:29
 */
@Service("relationService")
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements RelationService {

}

