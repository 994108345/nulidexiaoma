package cn.wzl.nulidexiaoma.api;

import cn.wzl.nulidexiaoma.common.Exception.LoginException;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.model.User;

import java.util.List;

/**
 * Created by 99410 on 2017/12/6.
 */

public interface ILoginService {
    MessageInfo<List> selectUser(User user) throws LoginException;
}
