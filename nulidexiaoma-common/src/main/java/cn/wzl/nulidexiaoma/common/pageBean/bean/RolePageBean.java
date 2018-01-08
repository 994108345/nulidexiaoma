package cn.wzl.nulidexiaoma.common.pageBean.bean;

import cn.wzl.nulidexiaoma.common.pageBean.PageBean;

/**
 * Created by wenzailong on 2018/1/8.
 */
public class RolePageBean extends PageBean{

    private Integer id;

    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

}
