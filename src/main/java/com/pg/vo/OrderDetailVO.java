package com.pg.vo;

import lombok.Data;

/**
 * @Author pg
 * @Date 2021/12/1
 */
@Data
public class OrderDetailVO {
    private Integer id;
    private Integer quantity;
    private String name;
    private Float price;
    private String fileName;
    private Float cost;
}
