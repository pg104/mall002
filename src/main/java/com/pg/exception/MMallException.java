package com.pg.exception;

import com.pg.enums.ResponseEnum;

/**
 * @Author pg
 * @Date 2021/11/25
 */
public class MMallException extends RuntimeException{

    private ResponseEnum responseEnum;

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public void setResponseEnum(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }

    public MMallException(ResponseEnum responseEnum) {
        super(responseEnum.getMsg());
        this.responseEnum = responseEnum;
    }
}
