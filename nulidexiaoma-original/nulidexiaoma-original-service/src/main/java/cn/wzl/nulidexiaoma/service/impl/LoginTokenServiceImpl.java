package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.ILoginService;
import cn.wzl.nulidexiaoma.api.LoginTokenService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.UUIdUtils;
import cn.wzl.nulidexiaoma.common.exception.NulidexiaomaException;
import cn.wzl.nulidexiaoma.model.LoginToken;
import cn.wzl.nulidexiaoma.model.User;
import cn.wzl.nulidexiaoma.original.dao.login.ILoginTokenDao;
import cn.wzl.nulidexiaoma.original.dao.login.IUserDao;
import cn.wzl.nulidexiaoma.original.dao.login.impl.UserDaoImpl;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by 99410 on 2018/8/23.
 */
@Service
public class LoginTokenServiceImpl implements LoginTokenService{
    private static final Logger logger = LoggerFactory.getLogger(LoginTokenServiceImpl.class);
    @Autowired
    private ILoginTokenDao loginTokenDao;
    @Autowired
    private ILoginService loginService;
    @Autowired
    private IUserDao iUserDao;
    @Override
    public MessageInfo login(LoginToken loginToken) {
        MessageInfo messageInfo = new MessageInfo();
        try {
           String token = loginToken.getLoginToken();
           if(StringUtils.isEmpty(token)){
               String userName = loginToken.getUserName();
               String passWord = loginToken.getPassWord();
               User user = new User();
               user.setPassWord(passWord);
               user.setUserName(userName);
               List<User> userList = iUserDao.selectUser(user);
               if(userList.size()<1){
                   throw new Exception("用户名不存在");
               }else{
                   loginToken.setLoginToken(UUIdUtils.getOneUUId());
                   loginTokenDao.insertOne(loginToken);
                   messageInfo.setData(loginToken);
               }
           }else{
               List<LoginToken> tokenList = loginTokenDao.selectList(loginToken);
               if(CollectionUtils.isEmpty(tokenList)){
                   throw new NulidexiaomaException("请用账号密码登录");
               }else{
                   messageInfo.setData(loginToken);
               }
           }
        } catch (Exception e) {
            logger.error("单点登录失败"+e.getMessage());
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"单点登录失败"+e.getMessage());
        }
        return messageInfo;
    }

    @Override
    public MessageInfo logOut(LoginToken loginToken) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            String token = loginToken.getLoginToken();
            if(StringUtils.isEmpty(token)){
                throw new NulidexiaomaException("非法用户操作");
            }else{
                int returnNum = loginTokenDao.deleteOne(loginToken);
                if(returnNum != 1){
                    throw new NulidexiaomaException("非法用户操作");
                }
            }
        } catch (Exception e) {
            logger.error("注销失败"+e.getMessage());
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"注销失败"+e.getMessage());
        }
        return messageInfo;
    }
}
