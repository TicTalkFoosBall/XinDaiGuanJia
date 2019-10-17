package com.longer.creditManager.bean;

public class LoginBeae {

    /**
     * code : 000000
     * msg : null
     * result : {"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsZmNwIiwic2Vzc2lvbklkIjoiMWZlNDc0MTRjMzM2NDg0Y2I0OTI2Mzc3MTg5MDBjZTAiLCJleHAiOjE1Njk1NTM1NTl9.fDk7tO1FgGuy_o3gM3hP4fbMkfqG06j7BxVtrHIKw7w","id":null,"username":"root","fullname":"管理员","mobile":null,"idNo":null,"sex":null,"nativePlace":null,"telephone":null,"email":null,"politicalStatus":null,"job":null}
     */

    private String code;
    private Object msg;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsZmNwIiwic2Vzc2lvbklkIjoiMWZlNDc0MTRjMzM2NDg0Y2I0OTI2Mzc3MTg5MDBjZTAiLCJleHAiOjE1Njk1NTM1NTl9.fDk7tO1FgGuy_o3gM3hP4fbMkfqG06j7BxVtrHIKw7w
         * id : null
         * username : root
         * fullname : 管理员
         * mobile : null
         * idNo : null
         * sex : null
         * nativePlace : null
         * telephone : null
         * email : null
         * politicalStatus : null
         * job : null
         */

        private String token;
        private Object id;
        private String username;
        private String fullname;
        private Object mobile;
        private Object idNo;
        private Object sex;
        private Object nativePlace;
        private Object telephone;
        private Object email;
        private Object politicalStatus;
        private Object job;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public Object getIdNo() {
            return idNo;
        }

        public void setIdNo(Object idNo) {
            this.idNo = idNo;
        }

        public Object getSex() {
            return sex;
        }

        public void setSex(Object sex) {
            this.sex = sex;
        }

        public Object getNativePlace() {
            return nativePlace;
        }

        public void setNativePlace(Object nativePlace) {
            this.nativePlace = nativePlace;
        }

        public Object getTelephone() {
            return telephone;
        }

        public void setTelephone(Object telephone) {
            this.telephone = telephone;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getPoliticalStatus() {
            return politicalStatus;
        }

        public void setPoliticalStatus(Object politicalStatus) {
            this.politicalStatus = politicalStatus;
        }

        public Object getJob() {
            return job;
        }

        public void setJob(Object job) {
            this.job = job;
        }
    }
}
