package cn.wzl.nulidexiaoma.service.impl.bean;/**
 * Created by wenzailong on 2018/8/17.
 */

import cn.wzl.nulidexiaoma.model.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenzailong
 * @create 2018-08-17 14:48
 **/
public class BranchBean {
    private String label;
    private String data;
    private String expandedIcon;
    private String collapsedIcon;
    private Menu menu;
    private List<BranchBean> children = new ArrayList();

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getExpandedIcon() {
        return expandedIcon;
    }

    public void setExpandedIcon(String expandedIcon) {
        this.expandedIcon = expandedIcon;
    }

    public String getCollapsedIcon() {
        return collapsedIcon;
    }

    public void setCollapsedIcon(String collapsedIcon) {
        this.collapsedIcon = collapsedIcon;
    }

    public List<BranchBean> getChildren() {
        return children;
    }

    public void setChildren(List<BranchBean> children) {
        this.children = children;
    }
}
