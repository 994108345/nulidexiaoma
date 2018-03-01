package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IRedisService;
import cn.wzl.nulidexiaoma.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wenzailong on 2018/3/1.
 */
@Service("iRedisService")
public class RedisService implements  IRedisService{
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    IRedisService iRedisService;


    @Override
    public void addKey() {

    }
}
