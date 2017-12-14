package cn.wzl.nulidexiaoma.dao.login.api;

import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.User;

import java.util.List;

public interface IUserDao extends IBaseToolsDao{
    /*按条件查找用户*/
    List<User> selectUser(User user);

}