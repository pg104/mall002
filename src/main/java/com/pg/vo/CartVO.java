package com.pg.vo;

import lombok.Data;

/**
 * @Author pg
 * @Date 2021/11/30
 */
@Data
public class CartVO {
    private Integer id;
    private Integer productId;
    private Integer quantity;
    private Float cost;
    private String name;
    private String fileName;
    private Float price;
    private Integer stock;
}
