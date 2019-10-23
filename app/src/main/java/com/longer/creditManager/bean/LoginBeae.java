package com.longer.creditManager.bean;

import com.longer.creditManager.login.UserInfo;

public class LoginBeae {

    /**
     * code : 000000
     * msg : null
     * result : {"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsZmNwIiwic2Vzc2lvbklkIjoiMWZlNDc0MTRjMzM2NDg0Y2I0OTI2Mzc3MTg5MDBjZTAiLCJleHAiOjE1Njk1NTM1NTl9.fDk7tO1FgGuy_o3gM3hP4fbMkfqG06j7BxVtrHIKw7w","id":null,"username":"root","fullname":"管理员","mobile":null,"idNo":null,"sex":null,"nativePlace":null,"telephone":null,"email":null,"politicalStatus":null,"job":null}
     */

    private String code;
    private Object msg;
    private UserInfo result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public UserInfo getResult() {
        return result;
    }

    public void setResult(UserInfo result) {
        this.result = result;
    }


}
