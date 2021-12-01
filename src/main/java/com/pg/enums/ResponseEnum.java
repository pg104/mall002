package com.pg.enums;

/**
 * @Author pg
 * @Date 2021/11/25
 */
public enum ResponseEnum {
    USER_INFO_NULL(300,"用户信息不能为空"),
    EMAIL_ERROR(301,"邮箱格式错误"),
    MOBILE_ERROR(302,"手机格式错误"),
    USERNAME_EXISTS(303,"用户名已存在"),
    USER_REGISTER_ERROR(304,"用户注册失败"),
    USERNAME_NOT_EXISTS(305,"用户名不存在"),
    PASSWORD_ERROR(306,"密码错误"),
    PARAMETER_NULL(307,"参数为空"),
    NOT_LOGIN(308,"未登录"),
    CART_ADD_ERROR(309,"添加购物车失败"),
    PRODUCT_NOT_EXISTS(310,"商品不存在"),
    PRODUCT_STOCK_ERROR(311,"商品库存不足"),
    CART_UPDATE_ERROR(312,"更新购物车失败"),
    CART_UPDATE_PARAMETER_ERROR(313,"更新购物车参数异常"),
    CART_UPDATE_STOCK_ERROR(314,"更新商品库存失败"),
    CART_REMOVE_ERROR(315,"删除购物车失败"),
    ORDERS_CREATE_ERROR(316,"创建订单主表失败"),
    ORDERS_DETAIL_CREATE_ERROR(317,"创建订单详情失败"),
    USER_ADDRESS_ADD_ERROR(318,"添加新地址失败"),
    USER_ADDRESS_SET_DEFAULT_ERROR(319,"默认地址修改失败");

    private Integer code;
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
