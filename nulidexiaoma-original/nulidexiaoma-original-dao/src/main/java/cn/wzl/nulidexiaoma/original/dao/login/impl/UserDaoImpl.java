package cn.wzl.nulidexiaoma.original.dao.login.impl;
import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.original.dao.login.IUserDao;
import cn.wzl.nulidexiaoma.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by 99410 on 2017/12/6.
 */
@Repository
public class UserDaoImpl extends BaseToolsDaoImpl implements IUserDao {

    public String getNameSpace() {
        return "IUserDao.";
    }
    @Override
    public List<User> selectUser(User user) {
        return localSqlSession.selectList(getNameSpace()+"selectUser",user);
    }

    @Override
    public int insertUserByTypeHandler(User user) {
        return localSqlSession.insert(getNameSpace() + "insertUserByTypeHandler",user);
    }

    @Override
    public int insertUserByRemarkTypeHandler(User user) {
        return localSqlSession.insert(getNameSpace() + "insertUserByRemarkTypeHandler",user);
    }

    @Override
    public List<User> selectRemarkTypeHandler(User user) {
        return localSqlSession.selectList(getNameSpace() + "selectRemarkTypeHandler",user);
    }
}
