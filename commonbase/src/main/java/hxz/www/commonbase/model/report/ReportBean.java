package hxz.www.commonbase.model.report;

import java.util.List;
import java.util.Map;

/**
 * @Author :rickBei
 * @Date :2019/11/5 14:48
 * @Descripe: From bug to bugs
 **/
public class ReportBean {

    private Map<String, String> data;
    private List<ConfigBean> config;

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public List<ConfigBean> getConfig() {
        return config;
    }

    public void setConfig(List<ConfigBean> config) {
        this.config = config;
    }

}

