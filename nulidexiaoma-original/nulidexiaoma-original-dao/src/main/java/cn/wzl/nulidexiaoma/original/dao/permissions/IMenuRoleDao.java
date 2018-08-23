package cn.wzl.nulidexiaoma.original.dao.permissions;


import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.RoleMenu;

public interface IMenuRoleDao extends IBaseToolsDao<RoleMenu> {

    /**
     * 根据role_id删除角色菜单
     * @param roleMenu
     * @return
     */
    int deleteRoleMenuByRoleId(RoleMenu roleMenu);
}