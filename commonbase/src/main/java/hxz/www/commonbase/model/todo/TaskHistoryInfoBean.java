package hxz.www.commonbase.model.todo;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

import hxz.www.commonbase.util.GsonUtil;

public class TaskHistoryInfoBean implements Serializable {

    @NonNull
    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }

        private List<HistoryData> data;
        private String resultMap;
        private int totalCount;
        public void setData(List<HistoryData> data) {
            this.data = data;
        }
        public List<HistoryData> getData() {
            return data;
        }

        public void setResultMap(String resultMap) {
            this.resultMap = resultMap;
        }
        public String getResultMap() {
            return resultMap;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }
        public int getTotalCount() {
            return totalCount;
        }



    }
