package com.longer.creditManager.net;

import java.io.Serializable;

 public class BaseResult<T> implements Serializable {

    private int code;
    private String msg;
    private T result;



    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }



    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

     public T getResult() {
         return result;
     }

     public void setResult(T result) {
         this.result = result;
     }
 }
