package cn.wzl.nulidexiaoma.api;

import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.model.LoginToken;

/**
 * Created by 99410 on 2018/8/23.
 */
public interface LoginTokenService {
    /**
     * 登录
     * @param loginToken
     * @return
     */
    MessageInfo login(LoginToken loginToken);

    /**
     * 注销
     * @param loginToken
     * @return
     */
    MessageInfo logOut(LoginToken loginToken);
}
