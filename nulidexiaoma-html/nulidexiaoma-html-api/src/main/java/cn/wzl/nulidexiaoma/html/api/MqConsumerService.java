package cn.wzl.nulidexiaoma.html.api;

import cn.wzl.nulidexiaoma.common.MessageInfo;
import org.springframework.stereotype.Service;

import javax.jms.Message;

/**
 * Created by 99410 on 2018/8/31.
 */

public interface MqConsumerService{
    void onMessage(Message message) ;
}
