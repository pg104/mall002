package com.pg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pg.entity.Product;
import com.pg.mapper.ProductMapper;
import com.pg.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAllByTypeAndProductCategoryId(Integer type, Integer id) {
        QueryWrapper<Product> wrapper = new QueryWrapper();
        String column = null;
        switch (type){
            case 1:
                column = "categorylevelone_id";
                break;
            case 2:
                column = "categoryleveltwo_id";
                break;
            case 3:
                column = "categorylevelthree_id";
                break;
        }
        wrapper.eq(column,id);
        List<Product> productList = productMapper.selectList(wrapper);
        return productList;
    }
}
