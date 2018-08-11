package cn.wzl.nulidexiaoma.model;

import java.util.Date;

public class ThreadTest {
    private Integer thradId;

    private String name;

    private Date createDate;

    private Date lastModifyDate;

    public Integer getThradId() {
        return thradId;
    }

    public void setThradId(Integer thradId) {
        this.thradId = thradId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
}