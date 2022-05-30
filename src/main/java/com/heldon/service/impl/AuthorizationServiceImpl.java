package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.mapper.AuthorizationMapper;
import com.heldon.entity.Authorization;
import com.heldon.service.AuthorizationService;
import org.springframework.stereotype.Service;

/**
 * (Authorization)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:25
 */
@Service("authorizationService")
public class AuthorizationServiceImpl extends ServiceImpl<AuthorizationMapper, Authorization> implements AuthorizationService {

}

