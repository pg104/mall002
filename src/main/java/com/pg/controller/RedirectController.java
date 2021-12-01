package com.pg.controller;

import com.pg.entity.User;
import com.pg.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @Author pg
 * @Date 2021/11/25
 */
@Controller
public class RedirectController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{url}")
    public ModelAndView redirect(@PathVariable("url") String url,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(url);
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

    @GetMapping("/")
    public String main(){
        return "redirect:/productCategory/main";
    }

    @GetMapping("favicon")
    @ResponseBody
    void returnNoFavicon(){
    }
}
