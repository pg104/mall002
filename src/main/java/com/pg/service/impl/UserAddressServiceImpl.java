package com.pg.service.impl;

import com.pg.entity.UserAddress;
import com.pg.mapper.UserAddressMapper;
import com.pg.service.UserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

}
