package cn.wzl.nulidexiaoma.dao.permissions.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.dao.permissions.IMenuDao;
import cn.wzl.nulidexiaoma.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wenzailong on 2017/12/29.
 */
@Repository
public class MenuDaoImpl extends BaseToolsDaoImpl<Menu> implements IMenuDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.permissions.impl.MenuDaoImpl.";
    }
}
