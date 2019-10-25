package hxz.www.commonbase.model.todo;


import java.util.List;

public class TodoBean{
    private int pageNo;
    private int pageSize;
    private long pages;
    private int total;
    private List<TodoItem> list;
    private int pageStart;
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public int getPageNo() {
        return pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }
    public long getPages() {
        return pages;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public int getTotal() {
        return total;
    }

    public void setList(List<TodoItem> list) {
        this.list = list;
    }
    public List<TodoItem> getList() {
        return list;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }
    public int getPageStart() {
        return pageStart;
    }
}
