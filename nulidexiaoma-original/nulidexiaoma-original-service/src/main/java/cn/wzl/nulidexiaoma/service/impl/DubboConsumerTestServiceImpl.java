package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/7/30.
 */

import cn.wzl.nulidexiaoma.api.DubboConsumerTestService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.html.api.BarService;
import cn.wzl.nulidexiaoma.html.api.CallBackService;
import cn.wzl.nulidexiaoma.html.api.CallbackListener;
import cn.wzl.nulidexiaoma.html.api.DubboProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wenzailong
 * @create 2018-07-30 13:43
 **/
@Service
public class DubboConsumerTestServiceImpl implements DubboConsumerTestService {
    private final static  Logger logger = LoggerFactory.getLogger(DubboConsumerTestServiceImpl.class);
    public Map<Integer, String> ret    = new HashMap<Integer, String>();
    public Map<Integer, Throwable> errors = new HashMap<Integer, Throwable>();
   /* @Autowired
    private DubboProviderService dubboProvider;*/
//    @Resource
//    private BarService barService;
  /*  @Autowired
    private CallBackService callbackService;*/
    @Override
    public MessageInfo consumerTest(String name) {
        System.out.println(name+"提供服务");
//        MessageInfo messageInfo = dubboProvider.providerTest("wenzailong");
//        return messageInfo;
        return null;
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
//            barService.genericInvoke();
//            barService.genericInvoke();
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return messageInfo;
    }

    @Override
    public void callBackTest() {
//        callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", new CallbackListener(){
//            public void changed(String msg) {
//                System.out.println("callback1:" + msg);
//            }
//        });
    }

    @Override
    public void onreturn(String msg, Integer id) {
        System.out.println("onreturn:" + msg);
        ret.put(id, msg);
        System.out.println("事件通知-服务被调用时");
    }

    @Override
    public void onthrow(Throwable ex, Integer id) {
        errors.put(id, ex);
        System.out.println("事件通知-服务报错时");
    }
}
