package cn.wzl.nulidexiaoma.original.dao.permissions;


import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.RoleUser;

import java.util.List;

public interface IRoleUserDao extends IBaseToolsDao<RoleUser>{

    /**
     * 根据条件查找角色用户表
     * @param roleUser
     * @return
     */
    List<RoleUser> listRoleUserBycondition(RoleUser roleUser);
}