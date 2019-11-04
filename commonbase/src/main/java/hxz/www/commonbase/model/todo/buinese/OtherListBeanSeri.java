package hxz.www.commonbase.model.todo.buinese;

import java.io.Serializable;
import java.util.List;

/**
 * @Author :rickBei
 * @Date :2019/11/4 15:38
 * @Descripe: From bug to bugs
 **/
public class OtherListBeanSeri implements Serializable {
    private List<OtherListBean> otherListBeans;

    public List<OtherListBean> getOtherListBeans() {
        return otherListBeans;
    }

    public void setOtherListBeans(List<OtherListBean> otherListBeans) {
        this.otherListBeans = otherListBeans;
    }
}
