package hxz.www.commonbase.model.todo;

import java.io.Serializable;

public   class FieldListBean implements Serializable {
            /**
             * fieldName : BusinessNo
             * fieldNote : 业务编号
             * controlType : searchComponent
             * value :
             */

            private String fieldName;
            private String fieldNote;
            private String controlType;
            private String value;

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

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }