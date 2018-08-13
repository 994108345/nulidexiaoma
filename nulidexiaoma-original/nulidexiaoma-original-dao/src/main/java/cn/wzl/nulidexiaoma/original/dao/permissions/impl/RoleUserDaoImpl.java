package cn.wzl.nulidexiaoma.original.dao.permissions.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.original.dao.permissions.IRoleUserDao;
import cn.wzl.nulidexiaoma.model.RoleUser;
import org.springframework.stereotype.Repository;

/**
 * Created by wenzailong on 2017/12/29.
 */
@Repository
public class RoleUserDaoImpl extends BaseToolsDaoImpl<RoleUser> implements IRoleUserDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.original.dao.permissions.impl.RoleUserDaoImpl.";
    }
}
