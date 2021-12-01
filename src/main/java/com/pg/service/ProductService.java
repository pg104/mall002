package com.pg.service;

import com.pg.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
public interface ProductService extends IService<Product> {
    public List<Product> findAllByTypeAndProductCategoryId(Integer type,Integer id);
}
