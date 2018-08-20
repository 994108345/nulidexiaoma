package cn.wzl.nulidexiaoma.model;

public class Dept {
    private Integer id;

    private String deptId;

    private String deptName;

    private String deptParent;

    private String deptState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptParent() {
        return deptParent;
    }

    public void setDeptParent(String deptParent) {
        this.deptParent = deptParent == null ? null : deptParent.trim();
    }

    public String getDeptState() {
        return deptState;
    }

    public void setDeptState(String deptState) {
        this.deptState = deptState == null ? null : deptState.trim();
    }
}