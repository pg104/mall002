package com.pg.mapper;

import com.pg.entity.UserAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.coyote.OutputBuffer;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
public interface UserAddressMapper extends BaseMapper<UserAddress> {
    public int setDefault(Integer userId);
}
