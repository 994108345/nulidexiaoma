package cn.wzl.nulidexiaoma.dao.api;

import cn.wzl.nulidexiaoma.common.daobase.IBaseDao;
import cn.wzl.nulidexiaoma.model.User;

import java.util.List;

public interface IUserDao extends  IBaseDao {
    /*按条件查找用户*/
    List<User> selectUser(User user);

}