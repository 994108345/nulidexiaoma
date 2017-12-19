package cn.wzl.nulidexiaoma.dao.login.impl;
import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.dao.login.IUserDao;
import cn.wzl.nulidexiaoma.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by 99410 on 2017/12/6.
 */
@Repository
public class UserDaoImpl extends BaseToolsDaoImpl implements IUserDao {

    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.login.IUserDao.";
    }
    @Override
    public List<User> selectUser(User user) {
        return localSqlSession.selectList(getNameSpace()+"selectUser",user);
    }
}
