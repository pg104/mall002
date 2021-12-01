package com.pg.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pg.entity.Cart;
import com.pg.entity.Orders;
import com.pg.entity.User;
import com.pg.enums.ResponseEnum;
import com.pg.exception.MMallException;
import com.pg.service.CartService;
import com.pg.service.UserAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
@Controller
@RequestMapping("/cart")
@Slf4j
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserAddressService userAddressService;

    /**
     * 添加购物车
     * @param productId
     * @param price
     * @param quantity
     * @param session
     * @return
     */
    @GetMapping("/add/{productId}/{price}/{quantity}")
    public String add(@PathVariable("productId") Integer productId, @PathVariable("price") Float price, @PathVariable("quantity") Integer quantity, HttpSession session){
        if (productId == null || price == null || quantity == null){
            log.info("【添加购物车】参数为空");
            throw new MMallException(ResponseEnum.PARAMETER_NULL);
        }
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if (user == null){
            log.info("【添加购物车】当前为未登录状态");
            throw new MMallException(ResponseEnum.NOT_LOGIN);
        }
        Cart cart = new Cart();
        cart.setUserId(user.getId());
        cart.setProductId(productId);
        cart.setQuantity(quantity);
        cart.setCost(price * quantity);
        Boolean add = cartService.add(cart);
        if (!add){
            log.info("【添加购物车】添加失败");
            throw new MMallException(ResponseEnum.CART_ADD_ERROR);
        }
        return "redirect:/cart/get";
    }

    /**
     * 查看购物车
     * @param session
     * @return
     */
    @GetMapping("/get")
    public ModelAndView get(HttpSession session){
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if (user == null){
            log.info("【添加购物车】当前为未登录状态");
            throw new MMallException(ResponseEnum.NOT_LOGIN);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("settlement1");
        modelAndView.addObject("cartList",cartService.findVOListByUserId(user.getId()));
        return modelAndView;
    }

    /**
     * 更新购物车
     * @param id
     * @param quantity
     * @param cost
     * @param session
     * @return
     */
    @PostMapping("/update/{id}/{quantity}/{cost}")
    @ResponseBody
    public String update(@PathVariable("id") Integer id,@PathVariable("quantity") Integer quantity,@PathVariable("cost") Float cost,HttpSession session){
        if (id == null || quantity == null || cost == null){
            log.info("【更新购物车】参数为空");
            throw new MMallException(ResponseEnum.PARAMETER_NULL);
        }
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if (user == null){
            log.info("【更新购物车】当前为未登录状态");
            throw new MMallException(ResponseEnum.NOT_LOGIN);
        }
        Boolean update = cartService.update(id, quantity, cost);
        if (update) return "success";
        return "fail";
    }

    /**
     * 删除购物车
     * @param id
     * @param session
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,HttpSession session){
        if (id == null){
            log.info("【删除购物车】参数为空");
            throw new MMallException(ResponseEnum.PARAMETER_NULL);
        }
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if (user == null){
            log.info("【删除购物车】当前为未登录状态");
            throw new MMallException(ResponseEnum.NOT_LOGIN);
        }
        Boolean delete = cartService.delete(id);
        if (delete) return "redirect:/cart/get";
        return null;
    }

    /**
     * 确认订单
     * @param session
     * @return
     */
    @GetMapping("/confirm")
    public ModelAndView confirm(HttpSession session){
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if (user == null){
            log.info("【确认订单】当前为未登录状态");
            throw new MMallException(ResponseEnum.NOT_LOGIN);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("settlement2");
        modelAndView.addObject("cartList",cartService.findVOListByUserId(user.getId()));
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getId());
        modelAndView.addObject("addressList",userAddressService.list(wrapper));
        return modelAndView;
    }

    /**
     * 提交订单
     * @param userAddress
     * @param session
     * @return
     */
    @PostMapping("/commit")
    public ModelAndView commit(String userAddress,String address,String remark,HttpSession session){
        if (userAddress == null || address == null || remark == null){
            log.info("【提交订单】参数为空");
            throw new MMallException(ResponseEnum.PARAMETER_NULL);
        }
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if (user == null){
            log.info("【提交订单】当前为未登录状态");
            throw new MMallException(ResponseEnum.NOT_LOGIN);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("settlement3");
        Orders orders = cartService.commit(userAddress,address,remark,user);
        if (orders != null) {
            modelAndView.addObject("orders",orders);
            modelAndView.addObject("cartList",cartService.findVOListByUserId(user.getId()));
            return modelAndView;
        }
        return null;
    }

}

