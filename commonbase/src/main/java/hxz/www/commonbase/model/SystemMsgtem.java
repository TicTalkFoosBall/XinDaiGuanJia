package hxz.www.commonbase.model;

import android.support.annotation.NonNull;

import hxz.www.commonbase.util.GsonUtil;

public class SystemMsgtem {

    private long id;
    private String title;

    private Long createdTime;
    private String content;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCreatetime(Long createtime) {
        this.createdTime = createtime;
    }

    public Long getCreatetime() {
        return createdTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @NonNull
    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}

