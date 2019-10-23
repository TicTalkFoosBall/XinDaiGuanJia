package com.longer.creditManager.systemmsg;

import android.support.annotation.NonNull;

import java.util.List;

import hxz.www.commonbase.util.GsonUtil;


public  class SystemMsgModel {

private int pageno;
private int pagesize;
private int pages;
private int total;
private List<SystemMsgtem> list;
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

public void setList(List<SystemMsgtem> list) {
        this.list = list;
        }
public List<SystemMsgtem> getList() {
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

