package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/7/30.
 */

import cn.wzl.nulidexiaoma.api.DubboConsumerTestService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
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
    private DubboProviderServiceImpl dubboProvider;
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
            DubboProviderServiceImpl dubboProviderService = (DubboProviderServiceImpl)context.getBean("dubboProviderService");
            dubboProviderService.providerTest("boob");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

    }
}
