package cn.wzl.nulidexiaoma.api;

import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.MenuPageBean;
import cn.wzl.nulidexiaoma.model.Menu;

import java.util.List;

/**
 * Created by wenzailong on 2018/1/9.
 */
public interface IMenuService {
    /**
     * 获取分页数据
     * @param menuPageBean
     * @return
     */
    public SearchResult getPageBean(MenuPageBean menuPageBean);

    /**
     * 批量查询
     * @param menu
     * @return
     */
    public MessageInfo selectList(Menu menu);

    /**
     * 查找所有菜单
     * @param menu
     * @return
     */
    public MessageInfo selectAllList(Menu menu);

    /**
     * 批量插入菜单
     * @param list
     * @return
     */
    public MessageInfo insertList(List list);

    /**
     * 删除一条记录
     * @param menu
     * @return
     */
    public MessageInfo deleteOne(Menu menu);

    /**
     * 更新一条记录
     * @param menu
     * @return
     */
    public MessageInfo updateOne(Menu menu);
}
