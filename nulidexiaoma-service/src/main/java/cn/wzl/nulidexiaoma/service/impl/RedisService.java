package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IRedisService;
import cn.wzl.nulidexiaoma.common.JSONutils;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.redis.CacheProxy;
import cn.wzl.nulidexiaoma.common.redis.RedisUtil;
import cn.wzl.nulidexiaoma.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.Cache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzailong on 2018/3/1.
 */
@Service("redisService")
public class RedisService implements  IRedisService{
    @Autowired
    CacheProxy cacheProxy;

    @Override
    public MessageInfo addListKey(User user) {
        MessageInfo messageInfo = new MessageInfo();
        String str = null;
        try {
            str = JSONutils.ObjectToJson(user);
            cacheProxy.lpush("loginRecord",str);
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"添加列表信息出错：" + e.getMessage());
        }
        return  messageInfo;
    }

    @Override
    public MessageInfo getListTop10(){
        MessageInfo messageInfo = new MessageInfo();
        try {

            List<String> list = cacheProxy.lrange("loginRecord",0,10);
            List<User> resultList = new ArrayList();
            for (String str: list) {
                User user = JSONutils.jsonStrToObj(str,User.class);
                resultList.add(user);
            }
            messageInfo.setData(resultList);
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"获取最近用户登录信息出错" + e.getMessage());
        }
        return messageInfo;
    }
}
