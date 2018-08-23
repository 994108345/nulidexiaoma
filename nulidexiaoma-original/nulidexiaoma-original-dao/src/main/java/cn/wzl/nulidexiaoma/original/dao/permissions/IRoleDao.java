package cn.wzl.nulidexiaoma.original.dao.permissions;


import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.Menu;
import cn.wzl.nulidexiaoma.model.Role;

import java.util.List;

public interface IRoleDao extends IBaseToolsDao<Role>{

    /**
     * 根据role_id查询菜单
     * @param role
     * @return
     */
    List<Menu> listMenuByRoleId(Role role);
}