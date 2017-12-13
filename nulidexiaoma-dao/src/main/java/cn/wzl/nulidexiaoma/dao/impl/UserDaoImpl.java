package cn.wzl.nulidexiaoma.dao.impl;

import cn.wzl.nulidexiaoma.common.daobase.BaseDaoImpl;
import cn.wzl.nulidexiaoma.common.daobase.IBaseDao;
import cn.wzl.nulidexiaoma.dao.api.IUserDao;
import cn.wzl.nulidexiaoma.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 99410 on 2017/12/6.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.impl.UserDaoImpl.";
    }

    @Override
    public List<User> selectUser(User user) {
        return localSqlSession.selectList(getNameSpace()+"selectUser",user);
    }
}
