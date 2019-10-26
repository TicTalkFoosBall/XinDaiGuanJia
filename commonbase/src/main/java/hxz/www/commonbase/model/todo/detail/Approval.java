package hxz.www.commonbase.model.todo.detail;

import java.util.List;

import hxz.www.commonbase.util.GsonUtil;

/**
 * @Author :rickBei
 * @Date :2019/10/26 16:47
 * @Descripe: From bug to bugs
 **/
public class Approval {

    /**
     * taskId : 2558658
     * processInstanceId : 2558242
     * nextActivitityId :
     * nextActivitityName :
     * result : {"code":"OK","desc":"同意"}
     * comment : 同意
     * nextSpecifiedOperaterIds : []
     * nextSpecifiedOperaterNames : []
     * isLastTask :
     * nrOfCompletedInstances :
     * nrOfInstances :
     * nrOfActiveInstances :
     * formEditData : {}
     * nextAllOperaterIds : []
     * masterId : 98384834488961258
     */

    private String taskId;
    private String processInstanceId;
    private String nextActivitityId;
    private String nextActivitityName;
    private ResultBean result=new ResultBean();
    private String comment;
    private String isLastTask;
    private String nrOfCompletedInstances;
    private String nrOfInstances;
    private String nrOfActiveInstances;
    private FormEditDataBean formEditData=new FormEditDataBean();
    private String masterId;
    private List<?> nextSpecifiedOperaterIds;
    private List<?> nextSpecifiedOperaterNames;
    private List<?> nextAllOperaterIds;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getNextActivitityId() {
        return nextActivitityId;
    }

    public void setNextActivitityId(String nextActivitityId) {
        this.nextActivitityId = nextActivitityId;
    }

    public String getNextActivitityName() {
        return nextActivitityName;
    }

    public void setNextActivitityName(String nextActivitityName) {
        this.nextActivitityName = nextActivitityName;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIsLastTask() {
        return isLastTask;
    }

    public void setIsLastTask(String isLastTask) {
        this.isLastTask = isLastTask;
    }

    public String getNrOfCompletedInstances() {
        return nrOfCompletedInstances;
    }

    public void setNrOfCompletedInstances(String nrOfCompletedInstances) {
        this.nrOfCompletedInstances = nrOfCompletedInstances;
    }

    public String getNrOfInstances() {
        return nrOfInstances;
    }

    public void setNrOfInstances(String nrOfInstances) {
        this.nrOfInstances = nrOfInstances;
    }

    public String getNrOfActiveInstances() {
        return nrOfActiveInstances;
    }

    public void setNrOfActiveInstances(String nrOfActiveInstances) {
        this.nrOfActiveInstances = nrOfActiveInstances;
    }

    public FormEditDataBean getFormEditData() {
        return formEditData;
    }

    public void setFormEditData(FormEditDataBean formEditData) {
        this.formEditData = formEditData;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public List<?> getNextSpecifiedOperaterIds() {
        return nextSpecifiedOperaterIds;
    }

    public void setNextSpecifiedOperaterIds(List<?> nextSpecifiedOperaterIds) {
        this.nextSpecifiedOperaterIds = nextSpecifiedOperaterIds;
    }

    public List<?> getNextSpecifiedOperaterNames() {
        return nextSpecifiedOperaterNames;
    }

    public void setNextSpecifiedOperaterNames(List<?> nextSpecifiedOperaterNames) {
        this.nextSpecifiedOperaterNames = nextSpecifiedOperaterNames;
    }

    public List<?> getNextAllOperaterIds() {
        return nextAllOperaterIds;
    }

    public void setNextAllOperaterIds(List<?> nextAllOperaterIds) {
        this.nextAllOperaterIds = nextAllOperaterIds;
    }

    public static class ResultBean {
        private String code;
        private String desc;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public static class FormEditDataBean {
    }


    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}
