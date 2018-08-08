package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/8/7.
 */

import cn.wzl.nulidexiaoma.html.api.EventNotifyService;
import org.springframework.stereotype.Service;

/**
 * @author wenzailong
 * @create 2018-08-07 19:52
 **/
@Service
public class EventNotifyServiceImpl implements EventNotifyService {

    @Override
    public void notifyEvent(String message) {
        System.out.println("通知信息为：" + message);
    }
}
