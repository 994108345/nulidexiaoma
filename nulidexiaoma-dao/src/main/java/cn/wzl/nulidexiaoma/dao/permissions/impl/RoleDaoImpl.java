package cn.wzl.nulidexiaoma.dao.permissions.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.dao.permissions.IRoleDao;

/**
 * Created by wenzailong on 2017/12/29.
 */
public class RoleDaoImpl extends BaseToolsDaoImpl implements IRoleDao  {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.permissions.impl.BaseToolsDaoImpl.";
    }
}
