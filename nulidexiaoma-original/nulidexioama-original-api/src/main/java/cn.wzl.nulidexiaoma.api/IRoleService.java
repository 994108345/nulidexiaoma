package cn.wzl.nulidexiaoma.api;

import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.RolePageBean;
import cn.wzl.nulidexiaoma.model.Menu;
import cn.wzl.nulidexiaoma.model.Role;
import cn.wzl.nulidexiaoma.model.RoleUser;

import java.util.List;

/**
 * Created by wenzailong on 2018/1/8.
 */
public interface IRoleService {

    /**
     * 查询分页数据
     * @param rolePageBean
     * @return
     */
    public SearchResult getPageBean(RolePageBean rolePageBean);

    /**
     * 删除一条记录
     * @param role
     * @return
     */
    public MessageInfo deleteOne(Role role);

    /**
     * 更新一条记录
     * @return
     */
    public MessageInfo updateOne(Role role);

    /**
     * 批量插入
     * @param list
     * @return
     */
    public MessageInfo insertList(List list);

    /**
     * 添加一个角色
     * @param menu
     * @param role
     * @return
     */
    MessageInfo addOneRole(List menu,Role role);


    /**
     * 添加角色-事务操作
     * @param menu
     * @param role
     */
    void addRoleTrans(List menu,Role role);

    /**
     * 删除角色
     * @return
     */
    MessageInfo deleteRole(RoleUser roleUser);
}
