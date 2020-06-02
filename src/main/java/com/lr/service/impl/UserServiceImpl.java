package com.lr.service.impl;

import com.lr.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lr.mapper.UserMapper;
import com.lr.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
