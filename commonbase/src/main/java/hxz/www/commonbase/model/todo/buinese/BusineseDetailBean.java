package hxz.www.commonbase.model.todo.buinese;

import java.util.List;

/**
 * @Author :rickBei
 * @Date :2019/10/29 13:45
 * @Descripe: From bug to bugs
 **/
public class BusineseDetailBean {

        private List<TitleBean> title;
        private List<DataBean> data;

        public List<TitleBean> getTitle() {
            return title;
        }

        public void setTitle(List<TitleBean> title) {
            this.title = title;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }



    }
