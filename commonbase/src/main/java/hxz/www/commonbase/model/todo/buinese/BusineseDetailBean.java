package hxz.www.commonbase.model.todo.buinese;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author :rickBei
 * @Date :2019/10/29 13:45
 * @Descripe: From bug to bugs
 **/
public class BusineseDetailBean implements Serializable {

        private String title ;
        private List<Map<String,String>> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Map<String,String>> getData() {
            return data;
        }

        public void setData(List<Map<String,String>> data) {
            this.data = data;
        }



    }
