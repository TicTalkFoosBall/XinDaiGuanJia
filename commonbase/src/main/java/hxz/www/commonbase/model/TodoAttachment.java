package hxz.www.commonbase.model;

import java.util.List;

import hxz.www.commonbase.util.GsonUtil;

/**
 * @Author :rickBei
 * @Date :2019/11/1 17:32
 * @Descripe: From bug to bugs
 **/
public class TodoAttachment {

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
         * name : 微信图片_20191101105559_20191101134031
         * type : pic
         * path : /upload/20191101/20191101134031QimwnH.jpg
         */

        private String name;
        private String type;
        private String path;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }


        @Override
        public String toString() {
            return GsonUtil.toJson(this);
        }
    }
}
