package cn.wzl.nulidexiaoma.original.dao.permissions.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.model.Menu;
import cn.wzl.nulidexiaoma.original.dao.permissions.IRoleDao;
import cn.wzl.nulidexiaoma.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wenzailong on 2017/12/29.
 */
@Repository
public class RoleDaoImpl extends BaseToolsDaoImpl<Role> implements IRoleDao  {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.original.dao.permissions.IRoleDao.";
    }

    @Override
    public List<Menu> listMenuByRoleId(Role role) {
        return localSqlSession.selectList(getNameSpace() +"listMenuByRoleId",role);
    }
}
