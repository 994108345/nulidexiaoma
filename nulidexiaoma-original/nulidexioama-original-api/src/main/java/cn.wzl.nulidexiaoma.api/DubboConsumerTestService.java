package cn.wzl.nulidexiaoma.api;/**
 * Created by wenzailong on 2018/7/30.
 */

import cn.wzl.nulidexiaoma.common.MessageInfo;

/**
 * @author wenzailong
 * @create 2018-07-30 13:42
 **/
public interface DubboConsumerTestService {
    /**
     * dubbo消费者测试
     * @return
     */
    MessageInfo consumerTest(String name);

    /**
     * 泛型调用测试
     * @return
     */
    MessageInfo genericServiceTest();

    /**
     * 参数回调
     */
    void callBackTest();

    /**
     * 事件通知
     * @param msg
     * @param id
     */
    void onreturn(String msg, Integer id);

    /**
     * 事件通知
     * @param ex
     * @param id
     */
    void onthrow(Throwable ex, Integer id);
}
