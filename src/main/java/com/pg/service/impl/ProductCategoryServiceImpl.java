package com.pg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pg.entity.Product;
import com.pg.entity.ProductCategory;
import com.pg.mapper.ProductCategoryMapper;
import com.pg.mapper.ProductMapper;
import com.pg.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pg.vo.ProductCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Autowired
    private ProductMapper productMapper;

    /**
     * 构建商品分类菜单
     * @return
     */
    @Override
    public List<ProductCategoryVO> buildProductCategoryMenu() {
        //1、查询所有的商品分类数据
        List<ProductCategory> productCategoryList = productCategoryMapper.selectList(null);
        //2、数据类型转换成 ProductCategoryVO
        List<ProductCategoryVO> productCategoryVOList = productCategoryList.stream().map(ProductCategoryVO::new).collect(Collectors.toList());
        //3、进行父子级菜单的封装
        List<ProductCategoryVO> levelOneList = buildMenu(productCategoryVOList);
        return levelOneList;
    }

    @Override
    public List<ProductCategoryVO> findAllProductByCategoryLevelOne() {
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("type",1);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectList(wrapper);
        List<ProductCategoryVO> productCategoryVOList = productCategoryList.stream().map(ProductCategoryVO::new).collect(Collectors.toList());
        getLevelOneProduct(productCategoryVOList);
        return productCategoryVOList;
    }

    /**
     * 查询一级分类对应的商品信息
     */
    public void getLevelOneProduct(List<ProductCategoryVO> list){
        for (ProductCategoryVO vo : list) {
            QueryWrapper<Product> wrapper = new QueryWrapper<>();
            wrapper.eq("categorylevelone_id",vo.getId());
            List<Product> productList = productMapper.selectList(wrapper);
            vo.setProductList(productList);
        }
    }


    /**
     * 构建菜单
     * @param list
     */
    public List<ProductCategoryVO> buildMenu(List<ProductCategoryVO> list){
        //找到一级菜单
        List<ProductCategoryVO> levelOneList = list.stream().filter(c -> c.getParentId() == 0).collect(Collectors.toList());
        for (ProductCategoryVO vo : levelOneList) {
        recursion(list,vo);
        }
        return levelOneList;
    }

    /**
     * 递归分类
     * @param list
     * @param vo
     */
    public void recursion(List<ProductCategoryVO> list,ProductCategoryVO vo){
        //找到子菜单
        List<ProductCategoryVO> children = getChildren(list, vo);
        vo.setChildren(children);
        //继续查找子菜单
        if (children.size() > 0){
            for (ProductCategoryVO child : children) {
                recursion(list,child);
            }
        }
    }

    /**
     * 获取子菜单
     * @param list
     * @param vo
     */
    public List<ProductCategoryVO> getChildren(List<ProductCategoryVO> list,ProductCategoryVO vo){
        List<ProductCategoryVO> children = new ArrayList<>();
        Iterator<ProductCategoryVO> iterator = list.iterator();
        while (iterator.hasNext()) {
            ProductCategoryVO next = iterator.next();
            if (next.getParentId().equals(vo.getId())){
                children.add(next);
            }
        }
        return children;
    }

}
