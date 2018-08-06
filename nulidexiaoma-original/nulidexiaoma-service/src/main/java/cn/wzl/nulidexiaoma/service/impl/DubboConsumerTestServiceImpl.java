package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/7/30.
 */

import cn.wzl.nulidexiaoma.api.DubboConsumerTestService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.html.api.BarService;
import cn.wzl.nulidexiaoma.html.api.DubboProviderService;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author wenzailong
 * @create 2018-07-30 13:43
 **/
@Service
public class DubboConsumerTestServiceImpl implements DubboConsumerTestService {
    private final static  Logger logger = LoggerFactory.getLogger(DubboConsumerTestServiceImpl.class);
    @Autowired
    private DubboProviderService dubboProvider;
    @Autowired
    private BarService barService;
    @Override
    public MessageInfo consumerTest(String name) {
        System.out.println(name+"提供服务");
        MessageInfo messageInfo = dubboProvider.providerTest("wenzailong");
        return messageInfo;
    }

    public static void main(String[] args) {
        try{
            System.setProperty("java.net.preferIPv4Stack", "true");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo/dubbo-original-consumer.xml"});
            context.start();
            DubboProviderService dubboProviderService = (DubboProviderService)context.getBean("dubboProviderService");
            dubboProviderService.providerTest("boob");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

    }

    /*泛化调用*/
    @Override
    public MessageInfo genericServiceTest() {
        MessageInfo messageInfo = new MessageInfo();
        String[] strArr = new String[2];
        Object[] objArr = new Object[2];
        try {
            barService.genericInvoke();
//            barService.genericInvoke();
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return messageInfo;
    }
}
