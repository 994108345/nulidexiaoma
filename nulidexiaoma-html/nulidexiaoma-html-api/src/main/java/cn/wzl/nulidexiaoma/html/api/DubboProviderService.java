package cn.wzl.nulidexiaoma.html.api;/**
 * Created by wenzailong on 2018/7/30.
 */


import cn.wzl.nulidexiaoma.common.MessageInfo;

/**
 * @author wenzailong
 * @create 2018-07-30 11:47
 **/
public interface DubboProviderService {
    /**
     * 测试dubbo，服务提供
     * @param str
     * @return
     */
    MessageInfo providerTest(String str);


}
