package hxz.www.commonbase.model.report;

import java.util.List;

import hxz.www.commonbase.util.GsonUtil;

public class ConfigBean {

    private String gropname;
    private List<ListBean> list;

    public String getGropname() {
        return gropname;
    }

    public void setGropname(String gropname) {
        this.gropname = gropname;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * fieldGroupName : 无
         * fieldName : CREATED_DEPT
         * fieldNote : 创建人部门CODE
         * controlType : 0
         */

        private String fieldGroupName;
        private String fieldName;
        private String fieldNote;
        private String controlType;

        public String getFieldGroupName() {
            return fieldGroupName;
        }

        public void setFieldGroupName(String fieldGroupName) {
            this.fieldGroupName = fieldGroupName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldNote() {
            return fieldNote;
        }

        public void setFieldNote(String fieldNote) {
            this.fieldNote = fieldNote;
        }

        public String getControlType() {
            return controlType;
        }

        public void setControlType(String controlType) {
            this.controlType = controlType;
        }
    }


    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}