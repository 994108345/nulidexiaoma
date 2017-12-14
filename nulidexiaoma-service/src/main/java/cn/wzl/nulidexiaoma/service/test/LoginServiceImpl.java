package cn.wzl.nulidexiaoma.service.test;

import cn.wzl.nulidexiaoma.api.ILoginService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.dao.login.api.IUserDao;
import cn.wzl.nulidexiaoma.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 99410 on 2017/12/6.
 */
@Service
public class LoginServiceImpl implements ILoginService {
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Resource
    IUserDao userDao;
    @Override
    public MessageInfo<List> selectUser(User user){
        MessageInfo messageInfo = new MessageInfo();
        try {
            List list =userDao.selectUser(user);
            messageInfo.setData(list);
        }catch(Exception e){
            logger.error("查询用户表出1错！"+e.getMessage());
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"查找用户出错：" + e.getMessage());
        }
        return messageInfo;
    }
}
