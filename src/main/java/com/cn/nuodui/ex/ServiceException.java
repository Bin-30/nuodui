package com.cn.nuodui.ex;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException{
    private Integer state;

    public ServiceException(String message, Integer state) {
        super(message);
        this.state = state;
    }
}
