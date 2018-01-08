package cn.wzl.nulidexiaoma.dao.permissions.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.dao.permissions.IMenuUserDao;
import cn.wzl.nulidexiaoma.model.MenuUser;
import org.springframework.stereotype.Repository;

/**
 * Created by wenzailong on 2017/12/29.
 */
@Repository
public class MenuUserDaoImpl extends BaseToolsDaoImpl<MenuUser> implements IMenuUserDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.permissions.impl.MenuUserDaoImpl.";
    }
}
