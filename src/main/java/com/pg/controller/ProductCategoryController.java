package com.pg.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pg.entity.User;
import com.pg.service.CartService;
import com.pg.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private CartService cartService;

    /**
     * 首页数据
     * @param session
     * @return
     */
    @GetMapping("/main")
    public ModelAndView main(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        //封装商品分类菜单
        modelAndView.addObject("list",productCategoryService.buildProductCategoryMenu());
        //封装一级分类对应的商品信息
        modelAndView.addObject("levelOneProductList",productCategoryService.findAllProductByCategoryLevelOne());
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if (user == null){
            //未登录
            modelAndView.addObject("cartList",new ArrayList<>());
        } else {
            //已登录
            //查询该用户的购物车记录
            modelAndView.addObject("cartList",cartService.findVOListByUserId(user.getId()));
        }
        return modelAndView;
    }
}

