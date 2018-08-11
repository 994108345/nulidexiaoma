package cn.wzl.nulidexiaoma.original.dao.login;

import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.User;

import java.util.List;

public interface IUserDao extends IBaseToolsDao{
    /*按条件查找用户*/
    List<User> selectUser(User user);

    /**
     * 插入用户
     * @param user
     * @return
     */
    int insertUserByTypeHandler(User user);

    /**
     * 自定义Typehandler
     * @param user
     * @return
     */
    int insertUserByRemarkTypeHandler(User user);

    /**
     * 查询自定义TypeHAANDLER
     * @param user
     * @return
     */
    List<User> selectRemarkTypeHandler(User user);

}