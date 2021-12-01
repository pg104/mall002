package com.pg.mapper;

import com.pg.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
public interface ProductMapper extends BaseMapper<Product> {
    public Integer updateStockById(Integer id,Integer stock);
    public Integer getStockById(Integer id);
}
