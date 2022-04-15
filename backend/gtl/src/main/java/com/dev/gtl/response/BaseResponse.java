package com.dev.gtl.response;

import org.springframework.stereotype.Component;

public class BaseResponse<T> {
    
    private int code;

    private T data;

    private String message;


    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
    

}
