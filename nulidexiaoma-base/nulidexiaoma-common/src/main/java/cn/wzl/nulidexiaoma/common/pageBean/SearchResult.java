package cn.wzl.nulidexiaoma.common.pageBean;

import cn.wzl.nulidexiaoma.common.MessageInfo;

import java.io.Serializable;

/**
 * 作者：wenzailong
 * 日期：2017/8/22
 * 描述：分页基类
 */
public class SearchResult extends MessageInfo implements Serializable {

    public SearchResult() {
        this.setTotalRecords(0);
        this.setData(null);
        this.setStatus(10000);

    }

    private int totalRecords;//总记录数

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}
