package com.heldon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heldon.entity.CollectionNetwork;

import java.util.List;

/**
 * (CollectionNetwork)表服务接口
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:26
 */
public interface CollectionNetworkService extends IService<CollectionNetwork> {
    List<CollectionNetwork> checkIfCollected(Integer netId, Integer userId);
}

