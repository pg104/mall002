package com.pg;

import com.pg.service.ProductCategoryService;
import com.pg.vo.ProductCategoryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mall002ApplicationTests {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    void contextLoads() {
        List<ProductCategoryVO> productCategoryVOList = productCategoryService.buildProductCategoryMenu();
        int i = 0;
    }

}
