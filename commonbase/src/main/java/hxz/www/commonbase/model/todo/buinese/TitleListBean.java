package hxz.www.commonbase.model.todo.buinese;

import java.util.ArrayList;
import java.util.List;

public   class TitleListBean {
            /**
             * fieldName : ProductCode
             * fieldNote : 选择产品
             */

            private List<TitleBean> titleList=new ArrayList<>();

    public List<TitleBean> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<TitleBean> titleList) {
        this.titleList = titleList;
    }
}
