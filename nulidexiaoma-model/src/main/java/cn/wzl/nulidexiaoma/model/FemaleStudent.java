package cn.wzl.nulidexiaoma.model;

public class FemaleStudent {
    private Integer id;

    private Integer stuId;

    private String stuName;

    private String weight;

    private String hight;

    private String isBeautiful;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getHight() {
        return hight;
    }

    public void setHight(String hight) {
        this.hight = hight == null ? null : hight.trim();
    }

    public String getIsBeautiful() {
        return isBeautiful;
    }

    public void setIsBeautiful(String isBeautiful) {
        this.isBeautiful = isBeautiful == null ? null : isBeautiful.trim();
    }
}