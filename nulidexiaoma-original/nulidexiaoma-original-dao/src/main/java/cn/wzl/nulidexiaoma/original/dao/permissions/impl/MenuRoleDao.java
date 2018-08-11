package cn.wzl.nulidexiaoma.original.dao.permissions.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.original.dao.permissions.IMenuRoleDao;
import cn.wzl.nulidexiaoma.model.MenuRole;
import org.springframework.stereotype.Repository;

/**
 * Created by wenzailong on 2017/12/29.
 */
@Repository
public class MenuRoleDao extends BaseToolsDaoImpl<MenuRole> implements IMenuRoleDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.permissions.impl.MenuRoleDaoImpl.";
    }
}
