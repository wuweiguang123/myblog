package com.lr.service.impl;

import com.lr.entity.TMessage;
import com.lr.mapper.TMessageMapper;
import com.lr.service.ITMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TMessageServiceImpl extends ServiceImpl<TMessageMapper, TMessage> implements ITMessageService {

}
