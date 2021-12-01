package com.pg.service;

import com.pg.entity.Product;
import com.pg.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pg.vo.ProductCategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    public List<ProductCategoryVO> buildProductCategoryMenu();
    public List<ProductCategoryVO> findAllProductByCategoryLevelOne();

}
