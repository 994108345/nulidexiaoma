package cn.wzl.nulidexiaoma.original.dao.permissions.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.original.dao.permissions.IMenuDao;
import cn.wzl.nulidexiaoma.model.Menu;
import org.springframework.stereotype.Repository;

/**
 * Created by wenzailong on 2017/12/29.
 */
@Repository
public class MenuDaoImpl extends BaseToolsDaoImpl<Menu> implements IMenuDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.original.dao.permissions.impl.MenuDaoImpl.";
    }
}
