package cn.wzl.nulidexiaoma.api;

import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.MenuPageBean;

/**
 * Created by wenzailong on 2018/1/9.
 */
public interface IMenuService {
    public SearchResult getPageBean(MenuPageBean menuPageBean);
}
