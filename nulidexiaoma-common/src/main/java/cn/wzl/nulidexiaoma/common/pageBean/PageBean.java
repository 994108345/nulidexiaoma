package cn.wzl.nulidexiaoma.common.pageBean;

import java.io.Serializable;

/**
 * Created by wenzailong on 2018/1/8.
 */
public class PageBean implements Serializable{
    private int start ;
    private int end ;
    private int pageSize = 10;
    private int curPage = 1;
    public PageBean(){
        start = this.getStart();
        end = this.getEnd();
    }
    //oracle数据库用法
    /*public int getStart() {
        return (curPage - 1)*pageSize + 1;
    }*/
    //mysql数据库用法
    public int getStart() {
        return (curPage - 1)*pageSize;
    }
    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return curPage * pageSize;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
