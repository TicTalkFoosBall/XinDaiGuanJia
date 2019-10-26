/**
 * Copyright 2019 bejson.com
 */
package hxz.www.commonbase.model.todo.detail;

import java.io.Serializable;

import hxz.www.commonbase.model.todo.Result;
import hxz.www.commonbase.util.GsonUtil;

/**
 * Auto-generated: 2019-10-25 23:8:52
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class HistoryData implements Serializable {

    private String name;
    private String key;
    private String startTime;
    private String endTime;
    private String assignee;
    private String username;
    private String fullname;
    private String commentMsg;
    private String comment;
    private String extendInfo;
    private String taskId;
    private String spendTimes;
    private String nextSpecifiedOperaterIds;
    private String nextSpecifiedOperaterNames;
    private String sourceActivitityId;
    private String nextBrancheSequenceFlowId;
    private String nextBrancheSequenceFlowName;
    private String nextActivitityId;
    private String nextActivitityName;
    private Result result;
    private String loginUser;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setCommentMsg(String commentMsg) {
        this.commentMsg = commentMsg;
    }

    public String getCommentMsg() {
        return commentMsg;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }

    public String getExtendInfo() {
        return extendInfo;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setSpendTimes(String spendTimes) {
        this.spendTimes = spendTimes;
    }

    public String getSpendTimes() {
        return spendTimes;
    }

    public void setNextSpecifiedOperaterIds(String nextSpecifiedOperaterIds) {
        this.nextSpecifiedOperaterIds = nextSpecifiedOperaterIds;
    }

    public String getNextSpecifiedOperaterIds() {
        return nextSpecifiedOperaterIds;
    }

    public void setNextSpecifiedOperaterNames(String nextSpecifiedOperaterNames) {
        this.nextSpecifiedOperaterNames = nextSpecifiedOperaterNames;
    }

    public String getNextSpecifiedOperaterNames() {
        return nextSpecifiedOperaterNames;
    }

    public void setSourceActivitityId(String sourceActivitityId) {
        this.sourceActivitityId = sourceActivitityId;
    }

    public String getSourceActivitityId() {
        return sourceActivitityId;
    }

    public void setNextBrancheSequenceFlowId(String nextBrancheSequenceFlowId) {
        this.nextBrancheSequenceFlowId = nextBrancheSequenceFlowId;
    }

    public String getNextBrancheSequenceFlowId() {
        return nextBrancheSequenceFlowId;
    }

    public void setNextBrancheSequenceFlowName(String nextBrancheSequenceFlowName) {
        this.nextBrancheSequenceFlowName = nextBrancheSequenceFlowName;
    }

    public String getNextBrancheSequenceFlowName() {
        return nextBrancheSequenceFlowName;
    }

    public void setNextActivitityId(String nextActivitityId) {
        this.nextActivitityId = nextActivitityId;
    }

    public String getNextActivitityId() {
        return nextActivitityId;
    }

    public void setNextActivitityName(String nextActivitityName) {
        this.nextActivitityName = nextActivitityName;
    }

    public String getNextActivitityName() {
        return nextActivitityName;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getLoginUser() {
        return loginUser;
    }


    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}