package cn.wzl.nulidexiaoma.api;/**
 * Created by wenzailong on 2018/7/4.
 */

import cn.wzl.nulidexiaoma.common.MessageInfo;

/**
 * @author wenzailong
 * @create 2018-07-04 17:09
 **/
public interface MqService {
    MessageInfo sendTestMq(String mqStr);
}
