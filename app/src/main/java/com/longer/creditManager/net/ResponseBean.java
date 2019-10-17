package com.longer.creditManager.net;

/**
 *
 */
public class ResponseBean<T> {

    private String code;

    private String msg;

    private T data;



    public ResponseBean(String code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
