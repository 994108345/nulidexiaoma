package cn.wzl.nulidexiaoma.original.dao.login.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.original.dao.login.ILoginTokenDao;
import org.springframework.stereotype.Repository;

/**
 * Created by 99410 on 2018/8/23.
 */
@Repository
public class LoginTokenDaoImpl extends BaseToolsDaoImpl implements ILoginTokenDao{
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.original.dao.login.ILoginTokenDao.";
    }

}
