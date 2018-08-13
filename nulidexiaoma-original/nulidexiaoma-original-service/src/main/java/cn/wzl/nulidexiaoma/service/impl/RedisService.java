package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IRedisService;
import cn.wzl.nulidexiaoma.common.JSONutils;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.redis.CacheProxy;
import cn.wzl.nulidexiaoma.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzailong on 2018/3/1.
 */
@Service("redisService")
public class RedisService implements  IRedisService{
    @Autowired
    CacheProxy cacheProxy;
    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);
    public static final String clickTimes = "clickTimes";//记录点击次数的key

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

    @Override
    public MessageInfo addClickTimes() {
        MessageInfo messageInfo = new MessageInfo();
        try {
            isFirstAddClickTimes();
            /*点击次数加1*/
            cacheProxy.incrBy(clickTimes,1L);
        } catch (Exception e) {
            logger.error("累加网站点击数失败" + e.getMessage(),e);
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"累加网站点击数失败" + e.getMessage());
        }
        return messageInfo;
    }

    /*判断是否为初次加载，是初次加载则创建记录点击数的key*/
    public  void isFirstAddClickTimes(){
        boolean isExit = cacheProxy.exists(clickTimes);
        if(!isExit){
            cacheProxy.set(clickTimes,"0");
        }
    }

    @Override
    public MessageInfo getClickTimes() {
        MessageInfo messageInfo  = new MessageInfo();
        try {
            String clickTimesStr = cacheProxy.get(clickTimes);
            messageInfo.setData(clickTimesStr);
        } catch (Exception e) {
            logger.error("获取网站点击数失败" + e.getMessage(),e);
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"获取网站点击数失败" + e.getMessage());
        }
        return messageInfo;
    }
}
