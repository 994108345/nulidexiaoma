package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/7/30.
 */

import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.html.api.DubboProviderService;
import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenzailong
 * @create 2018-07-30 11:45
 **/
@Service
public class DubboProviderServiceImpl implements DubboProviderService {
    @Override
    public MessageInfo providerTest(String str) {
        MessageInfo messageInfo = new MessageInfo();
        System.out.println("我是tomcat:8079,zk:127.0.0.1:2181服务提供者，我被"+str+"消费了");
        messageInfo.setMessage("我是tomcat:8079,zk:127.0.0.1:2181服务提供者，我被"+str+"消费了");
        return messageInfo;
    }
}
