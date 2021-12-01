package com.pg.mapper;

import com.pg.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
public interface CartMapper extends BaseMapper<Cart> {
    public int update(Integer id,Integer quantity,Float cost);
    public Float getCostByUserId(Integer id);
}
