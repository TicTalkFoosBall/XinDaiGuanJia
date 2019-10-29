package hxz.www.commonbase.model.todo.buinese;

import java.io.Serializable;

public   class TitleBean implements Serializable {
            /**
             * fieldName : ProductCode
             * fieldNote : 选择产品
             */

            private String fieldName;
            private String fieldNote;

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
        }
