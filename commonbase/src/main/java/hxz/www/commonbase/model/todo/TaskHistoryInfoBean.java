package hxz.www.commonbase.model.todo;

import java.util.List;

public class TaskHistoryInfoBean {
    /**
     * data : []
     * totalCount : 0
     * resultMap : null
     */

    private int totalCount;
    private Object resultMap;
    private List<?> data;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Object getResultMap() {
        return resultMap;
    }

    public void setResultMap(Object resultMap) {
        this.resultMap = resultMap;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}