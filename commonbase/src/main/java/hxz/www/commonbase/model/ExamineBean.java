package hxz.www.commonbase.model;

import java.util.List;

/**
 *
 * 审批待办
 *
 *
 */
public class ExamineBean {


    /**
     * code : 000000
     * msg : null
     * result : {"pageNo":1,"pageSize":1000,"pages":0,"total":0,"list":[{"id":null,"code":null,"name":null,"fId":null,"bsCode":null,"bsName":null,"pId":null,"pName":null,"idPath":null,"namePath":null,"type":"oa","status":null,"remark":null,"createdDeptIds":null,"deptId":null,"deptName":null,"createdCompanyId":null,"createdCompanyName":null,"createdBy":null,"createdName":null,"createdTime":null,"lastUpdBy":null,"lastUpdTime":null,"deletedTime":null,"deletedBy":null,"user":null,"taskId":"001","taskName":"【客户经理/银行信贷员】 推荐项目","startTime":"2019-09-09 15:13:13","starterName":null,"timeout":"1212","level":"111","fieldList":[{"name":"请假类型","value":"事假"},{"name":"请假时间","value":"10天"}]},{"id":null,"code":null,"name":null,"fId":null,"bsCode":null,"bsName":null,"pId":null,"pName":null,"idPath":null,"namePath":null,"type":"oa","status":null,"remark":null,"createdDeptIds":null,"deptId":null,"deptName":null,"createdCompanyId":null,"createdCompanyName":null,"createdBy":null,"createdName":null,"createdTime":null,"lastUpdBy":null,"lastUpdTime":null,"deletedTime":null,"deletedBy":null,"user":null,"taskId":"002","taskName":"【客户经理/银行信贷员】 推荐项目","startTime":"2019-09-09 15:13:13","starterName":null,"timeout":"3434","level":"222","fieldList":[{"name":"贷款金额","value":"100000元"},{"name":"产品名称","value":"常规小贷"}]}],"pageStart":0}
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
         * pageNo : 1
         * pageSize : 1000
         * pages : 0
         * total : 0
         * list : [{"id":null,"code":null,"name":null,"fId":null,"bsCode":null,"bsName":null,"pId":null,"pName":null,"idPath":null,"namePath":null,"type":"oa","status":null,"remark":null,"createdDeptIds":null,"deptId":null,"deptName":null,"createdCompanyId":null,"createdCompanyName":null,"createdBy":null,"createdName":null,"createdTime":null,"lastUpdBy":null,"lastUpdTime":null,"deletedTime":null,"deletedBy":null,"user":null,"taskId":"001","taskName":"【客户经理/银行信贷员】 推荐项目","startTime":"2019-09-09 15:13:13","starterName":null,"timeout":"1212","level":"111","fieldList":[{"name":"请假类型","value":"事假"},{"name":"请假时间","value":"10天"}]},{"id":null,"code":null,"name":null,"fId":null,"bsCode":null,"bsName":null,"pId":null,"pName":null,"idPath":null,"namePath":null,"type":"oa","status":null,"remark":null,"createdDeptIds":null,"deptId":null,"deptName":null,"createdCompanyId":null,"createdCompanyName":null,"createdBy":null,"createdName":null,"createdTime":null,"lastUpdBy":null,"lastUpdTime":null,"deletedTime":null,"deletedBy":null,"user":null,"taskId":"002","taskName":"【客户经理/银行信贷员】 推荐项目","startTime":"2019-09-09 15:13:13","starterName":null,"timeout":"3434","level":"222","fieldList":[{"name":"贷款金额","value":"100000元"},{"name":"产品名称","value":"常规小贷"}]}]
         * pageStart : 0
         */

        private int pageNo;
        private int pageSize;
        private int pages;
        private int total;
        private int pageStart;
        private List<ListBean> list;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageStart() {
            return pageStart;
        }

        public void setPageStart(int pageStart) {
            this.pageStart = pageStart;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : null
             * code : null
             * name : null
             * fId : null
             * bsCode : null
             * bsName : null
             * pId : null
             * pName : null
             * idPath : null
             * namePath : null
             * type : oa
             * status : null
             * remark : null
             * createdDeptIds : null
             * deptId : null
             * deptName : null
             * createdCompanyId : null
             * createdCompanyName : null
             * createdBy : null
             * createdName : null
             * createdTime : null
             * lastUpdBy : null
             * lastUpdTime : null
             * deletedTime : null
             * deletedBy : null
             * user : null
             * taskId : 001
             * taskName : 【客户经理/银行信贷员】 推荐项目
             * startTime : 2019-09-09 15:13:13
             * starterName : null
             * timeout : 1212
             * level : 111
             * fieldList : [{"name":"请假类型","value":"事假"},{"name":"请假时间","value":"10天"}]
             */

            private Object id;
            private Object code;
            private Object name;
            private Object fId;
            private Object bsCode;
            private Object bsName;
            private Object pId;
            private Object pName;
            private Object idPath;
            private Object namePath;
            private String type;
            private Object status;
            private Object remark;
            private Object createdDeptIds;
            private Object deptId;
            private Object deptName;
            private Object createdCompanyId;
            private Object createdCompanyName;
            private Object createdBy;
            private Object createdName;
            private Object createdTime;
            private Object lastUpdBy;
            private Object lastUpdTime;
            private Object deletedTime;
            private Object deletedBy;
            private Object user;
            private String taskId;
            private String taskName;
            private String startTime;
            private Object starterName;
            private String timeout;
            private String level;
            private List<FieldListBean> fieldList;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getCode() {
                return code;
            }

            public void setCode(Object code) {
                this.code = code;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public Object getFId() {
                return fId;
            }

            public void setFId(Object fId) {
                this.fId = fId;
            }

            public Object getBsCode() {
                return bsCode;
            }

            public void setBsCode(Object bsCode) {
                this.bsCode = bsCode;
            }

            public Object getBsName() {
                return bsName;
            }

            public void setBsName(Object bsName) {
                this.bsName = bsName;
            }

            public Object getPId() {
                return pId;
            }

            public void setPId(Object pId) {
                this.pId = pId;
            }

            public Object getPName() {
                return pName;
            }

            public void setPName(Object pName) {
                this.pName = pName;
            }

            public Object getIdPath() {
                return idPath;
            }

            public void setIdPath(Object idPath) {
                this.idPath = idPath;
            }

            public Object getNamePath() {
                return namePath;
            }

            public void setNamePath(Object namePath) {
                this.namePath = namePath;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getCreatedDeptIds() {
                return createdDeptIds;
            }

            public void setCreatedDeptIds(Object createdDeptIds) {
                this.createdDeptIds = createdDeptIds;
            }

            public Object getDeptId() {
                return deptId;
            }

            public void setDeptId(Object deptId) {
                this.deptId = deptId;
            }

            public Object getDeptName() {
                return deptName;
            }

            public void setDeptName(Object deptName) {
                this.deptName = deptName;
            }

            public Object getCreatedCompanyId() {
                return createdCompanyId;
            }

            public void setCreatedCompanyId(Object createdCompanyId) {
                this.createdCompanyId = createdCompanyId;
            }

            public Object getCreatedCompanyName() {
                return createdCompanyName;
            }

            public void setCreatedCompanyName(Object createdCompanyName) {
                this.createdCompanyName = createdCompanyName;
            }

            public Object getCreatedBy() {
                return createdBy;
            }

            public void setCreatedBy(Object createdBy) {
                this.createdBy = createdBy;
            }

            public Object getCreatedName() {
                return createdName;
            }

            public void setCreatedName(Object createdName) {
                this.createdName = createdName;
            }

            public Object getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(Object createdTime) {
                this.createdTime = createdTime;
            }

            public Object getLastUpdBy() {
                return lastUpdBy;
            }

            public void setLastUpdBy(Object lastUpdBy) {
                this.lastUpdBy = lastUpdBy;
            }

            public Object getLastUpdTime() {
                return lastUpdTime;
            }

            public void setLastUpdTime(Object lastUpdTime) {
                this.lastUpdTime = lastUpdTime;
            }

            public Object getDeletedTime() {
                return deletedTime;
            }

            public void setDeletedTime(Object deletedTime) {
                this.deletedTime = deletedTime;
            }

            public Object getDeletedBy() {
                return deletedBy;
            }

            public void setDeletedBy(Object deletedBy) {
                this.deletedBy = deletedBy;
            }

            public Object getUser() {
                return user;
            }

            public void setUser(Object user) {
                this.user = user;
            }

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public String getTaskName() {
                return taskName;
            }

            public void setTaskName(String taskName) {
                this.taskName = taskName;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public Object getStarterName() {
                return starterName;
            }

            public void setStarterName(Object starterName) {
                this.starterName = starterName;
            }

            public String getTimeout() {
                return timeout;
            }

            public void setTimeout(String timeout) {
                this.timeout = timeout;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public List<FieldListBean> getFieldList() {
                return fieldList;
            }

            public void setFieldList(List<FieldListBean> fieldList) {
                this.fieldList = fieldList;
            }

            public static class FieldListBean {
                /**
                 * name : 请假类型
                 * value : 事假
                 */

                private String name;
                private String value;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}
