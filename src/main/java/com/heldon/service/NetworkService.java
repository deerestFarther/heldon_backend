package com.heldon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heldon.DTO.NetworkDTO;
import com.heldon.entity.Network;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * (Network)表服务接口
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:28
 */
public interface NetworkService extends IService<Network> {
    Integer insertOneNetwork(String netName, String imgUrl, Long userId);

}

