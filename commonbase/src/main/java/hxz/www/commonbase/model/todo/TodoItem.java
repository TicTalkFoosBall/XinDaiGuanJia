package hxz.www.commonbase.model.todo;

import android.support.annotation.NonNull;

import java.io.Serializable;

import hxz.www.commonbase.util.GsonUtil;


public class TodoItem implements Serializable {

    private String type;
    private String taskId;
    private String title;
    private String taskName;
    private String startTime;
    private String timeout;
    private String formGroupCode;
    private String procInstId;
    private String masterId;
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public String getTaskId() {
        return taskId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskName() {
        return taskName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getStartTime() {
        return startTime;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
    public String getTimeout() {
        return timeout;
    }

    public void setFormGroupCode(String formGroupCode) {
        this.formGroupCode = formGroupCode;
    }
    public String getFormGroupCode() {
        return formGroupCode;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }
    public String getMasterId() {
        return masterId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    @NonNull
    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}