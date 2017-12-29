package cn.wzl.nulidexiaoma.dao.permissions.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.dao.permissions.IRoleUserDao;
import cn.wzl.nulidexiaoma.model.RoleUser;

/**
 * Created by wenzailong on 2017/12/29.
 */
public class RoleUserDaoImpl extends BaseToolsDaoImpl implements IRoleUserDao{
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.permissions.impl.BaseToolsDaoImpl.";
    }
}
