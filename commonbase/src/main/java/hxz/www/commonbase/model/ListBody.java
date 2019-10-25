package hxz.www.commonbase.model;
/**
 *
 * 审批待办
 *
 */
public class ListBody {


    private String pageCount;
    private String pageIndex;


    public ListBody(String pageCount, String pageIndex) {
        this.pageCount = pageCount;
        this.pageIndex = pageIndex;
    }

    public ListBody() {
    }


    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }
}
