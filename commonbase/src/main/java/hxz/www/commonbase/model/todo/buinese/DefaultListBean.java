package hxz.www.commonbase.model.todo.buinese;

import hxz.www.commonbase.util.GsonUtil;

public class DefaultListBean {
    /**
     * code : BusinessSharingMechanism
     * icon : /upload/20191015/20191015175152fbHhRw.jpg
     * name : 业务分成机制
     * style : diamond
     */

    private String code;
    private String icon;
    private String name;
    private String style;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }


    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}