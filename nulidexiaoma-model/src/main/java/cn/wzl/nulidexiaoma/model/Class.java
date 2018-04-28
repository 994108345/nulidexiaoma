package cn.wzl.nulidexiaoma.model;

import java.util.List;

public class Class {
    private Integer id;

    private String clsCode;

    private String clsName;

    private Integer clsGred;

    private String clsNum;

    private List<Student> stuList;

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClsCode() {
        return clsCode;
    }

    public void setClsCode(String clsCode) {
        this.clsCode = clsCode == null ? null : clsCode.trim();
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName == null ? null : clsName.trim();
    }

    public Integer getClsGred() {
        return clsGred;
    }

    public void setClsGred(Integer clsGred) {
        this.clsGred = clsGred;
    }

    public String getClsNum() {
        return clsNum;
    }

    public void setClsNum(String clsNum) {
        this.clsNum = clsNum == null ? null : clsNum.trim();
    }
}