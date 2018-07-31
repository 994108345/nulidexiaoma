package cn.wzl.nulidexiaoma.api;

import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.model.User;

import java.util.List;

/**
 * Created by wenzailong on 2018/3/1.
 */
public interface IRedisService {
    /**
     * 在列表里添加一个元素
     * @param user
     */
    MessageInfo addListKey(User user);

    /**
     * 获取列表的前十个元素
     * @return
     * @throws Exception
     */
    MessageInfo getListTop10();
}
