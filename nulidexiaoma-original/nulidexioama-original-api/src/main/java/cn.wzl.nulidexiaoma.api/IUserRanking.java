package cn.wzl.nulidexiaoma.api;


import cn.wzl.nulidexiaoma.model.User;

import java.util.List;

/**
 * Created by wenzailong on 2018/3/2.
 */
public interface IUserRanking {
    /**
     * 添加用户信息
     */
    void addUserInfo(User user);

    /**
     *
     * 获取前十
     */
    List getTop10();

    /**
     *删除数据到前十
     */
    void removeUserInfo();
}
