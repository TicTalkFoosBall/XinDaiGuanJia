package hxz.www.commonbase.model.client;

import android.support.annotation.NonNull;

import java.io.Serializable;

import hxz.www.commonbase.util.GsonUtil;


public  class ClientModel implements Serializable {
        private String name;
                private String mobile;
                private String id;
                private String type;
                public void setName(String name) {
                        this.name = name;
                }
                public String getName() {
                        return name;
                }

                public void setMobile(String mobile) {
                        this.mobile = mobile;
                }
                public String getMobile() {
                        return mobile;
                }

                public void setId(String id) {
                        this.id = id;
                }
                public String getId() {
                        return id;
                }

                public void setType(String type) {
                        this.type = type;
                }
                public String getType() {
                        return type;
                }

        @NonNull
        @Override
        public String toString() {
                return GsonUtil.toJson(this);
        }
}