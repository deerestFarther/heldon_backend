package com.heldon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heldon.mapper.UserTagMapper;
import com.heldon.entity.UserTag;
import com.heldon.service.UserTagService;
import org.springframework.stereotype.Service;

/**
 * (UserTag)表服务实现类
 *
 * @author hanbaba
 * @since 2022-05-02 10:54:31
 */
@Service("userTagService")
public class UserTagServiceImpl extends ServiceImpl<UserTagMapper, UserTag> implements UserTagService {

}

