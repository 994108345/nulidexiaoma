package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.ILoginService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.original.dao.login.IUserDao;
import cn.wzl.nulidexiaoma.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 99410 on 2017/12/6.
 */
@Service("loginService")
public class LoginService implements ILoginService {
    private Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Resource
    IUserDao userDao;
    @Override
    public MessageInfo<List> selectUser(User user){
        MessageInfo messageInfo = new MessageInfo();
        try {
            List list =userDao.selectUser(user);
            if(list.size() <= 0){
                messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"用户名错误");
                return messageInfo;
            }
            messageInfo.setData(list);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("查询用户表出1错！"+e.getMessage());
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"查找用户出错：" + e.getMessage());
        }
        return messageInfo;
    }
}
