package cn.wzl.nulidexiaoma.dao.permissions.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.dao.permissions.IMenuDao;

/**
 * Created by wenzailong on 2017/12/29.
 */
public class MenuDaoImpl extends BaseToolsDaoImpl implements IMenuDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.permissions.impl.MenuDaoImpl.";
    }
}
