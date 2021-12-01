package com.pg.vo;

import com.pg.entity.Product;
import com.pg.entity.ProductCategory;
import lombok.Data;

import java.util.List;

/**
 * @Author pg
 * @Date 2021/11/25
 */
@Data
public class ProductCategoryVO {
    private Integer id;
    private String name;
    private Integer parentId;
    private List<ProductCategoryVO> children;
    private List<Product> productList;

    public ProductCategoryVO(ProductCategory productCategory) {
        this.id = productCategory.getId();
        this.name = productCategory.getName();
        this.parentId = productCategory.getParentId();
    }
}
