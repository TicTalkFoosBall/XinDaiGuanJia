package hxz.www.commonbase.model;

import android.support.annotation.NonNull;

import java.util.List;

import hxz.www.commonbase.util.GsonUtil;


public  class NoticeListModel {

private int pageno;
private int pagesize;
private int pages;
private int total;
private List<NoticeItem> list;
private int pagestart;
public void setPageno(int pageno) {
        this.pageno = pageno;
        }
public int getPageno() {
        return pageno;
        }

public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
        }
public int getPagesize() {
        return pagesize;
        }

public void setPages(int pages) {
        this.pages = pages;
        }
public int getPages() {
        return pages;
        }

public void setTotal(int total) {
        this.total = total;
        }
public int getTotal() {
        return total;
        }

public void setList(List<NoticeItem> list) {
        this.list = list;
        }
public List<NoticeItem> getList() {
        return list;
        }

public void setPagestart(int pagestart) {
        this.pagestart = pagestart;
        }
public int getPagestart() {
        return pagestart;
        }

        @NonNull
        @Override
        public String toString() {
                return GsonUtil.toJson(this);
        }
}

