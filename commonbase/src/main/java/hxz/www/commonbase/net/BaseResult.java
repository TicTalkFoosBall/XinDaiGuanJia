package hxz.www.commonbase.net;

import java.io.Serializable;

 public class BaseResult<T> implements Serializable {

    private String code;
    private String msg;
    private T result;



    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }



    public void setCode(String code) {
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
