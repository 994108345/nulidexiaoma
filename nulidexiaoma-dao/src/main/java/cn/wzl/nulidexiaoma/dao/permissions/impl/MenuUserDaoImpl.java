package cn.wzl.nulidexiaoma.dao.permissions.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.dao.permissions.IMenuUserDao;

/**
 * Created by wenzailong on 2017/12/29.
 */
public class MenuUserDaoImpl extends BaseToolsDaoImpl implements IMenuUserDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.permissions.impl.MenuUserDaoImpl.";
    }
}
