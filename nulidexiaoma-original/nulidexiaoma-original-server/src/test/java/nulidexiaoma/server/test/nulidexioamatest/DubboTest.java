package nulidexiaoma.server.test.nulidexioamatest;/**
 * Created by wenzailong on 2018/7/31.
 */

import cn.wzl.nulidexiaoma.api.DubboConsumerTestService;
import cn.wzl.nulidexiaoma.api.NotifyService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.exception.NulidexiaomaException;
import cn.wzl.nulidexiaoma.html.api.*;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * @author wenzailong
 * @create 2018-07-31 19:24
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class DubboTest implements ApplicationContextAware {

    private ApplicationContext context;
    @Autowired
    private DubboConsumerTestService dubboConsumerTestServiceImpl;
    @Resource
    private DubboProviderService dubboProvider;
   /* @Resource
    private NIoDubboOfAsyncAService asyncA;
    @Resource
    private NIoDubboOfAsyncBService asyncB;
    @Resource
    private EventNotifyService eventNotifyService;
    @Autowired
    private NotifyService notifyServiceImpl;
    @Resource
    private SubService subService;*/
    @Resource
    private MockService mockService;

    @Test
    public void provider(){
        try {
            MessageInfo messageInfo = new MessageInfo();
            for (int i = 0; i < 1; i++) {
                Thread thread1 = new Thread(new DubboThread("wenzailong"+i));
                thread1.start();
            }
            messageInfo = dubboConsumerTestServiceImpl.consumerTest("wenzailong");
            System.out.println(messageInfo.getMessage());
            Thread.sleep(1000*3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    class DubboThread implements  Runnable{

        String name;

        public DubboThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
          MessageInfo messageInfo = dubboConsumerTestServiceImpl.consumerTest(name + Thread.currentThread().getName());
            System.out.println("线程返回值"+messageInfo.getMessage());
        }
    }

    @Test
    public void aggregationTest(){
        MessageInfo messageInfo = dubboConsumerTestServiceImpl.consumerTest("wenzailong");
        System.out.println("分组聚合："+messageInfo.getMessage());
    }

    /*泛化调用*/
    @Test
    public void genericTest(){
        try {
            MessageInfo messageInfo = dubboConsumerTestServiceImpl.genericServiceTest();
            System.out.println(messageInfo.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void genericTestByConfig(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        context.start();
        System.out.println("consumer start");
        GenericService demoService = (GenericService) context.getBean("barService");
        System.out.println("consumer");
        Object result = demoService.$invoke("genericInvoke", null, null);
        System.out.println(result);
    }
    @Test
    public void genericTestBySpring(){
        try {
            GenericService genericService = (GenericService)context.getBean("barService");
            genericService.$invoke("genericInvoke", null, null);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*回声测试*/
    @Test
    public void echoServiceTest(){
        try {
//            EchoService service = (EchoService)context.getBean("dubboProvider");
            EchoService service = (EchoService)dubboProvider;
            String status = (String) service.$echo("OK");
            System.out.println(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*上下文信息*/
    @Test
    public void rpcContextTest(){
        /*本端是否问提供端*/
        boolean isProcider = RpcContext.getContext().isProviderSide();
        String clientIp = RpcContext.getContext().getRemoteHost();
        String application = RpcContext.getContext().getUrl().getParameter("application");
    }
   /* *//*异步调用*//*
    @Test
    public void asyncTest(){
        Date date = new Date();
        System.out.println("beginDate"+date);
        try {
            asyncB.asyncB();
            Future<String> futureA = RpcContext.getContext().getFuture();
            asyncA.asyncA();
            Future<String> futureB = RpcContext.getContext().getFuture();
            String a = futureA.get();
            String b = futureB.get();
            System.out.println("A返回的是" +a);
            System.out.println("B返回的是" +b);
            Date endDate = new Date();
            System.out.println("endDate" + endDate.compareTo(date));
            Thread.sleep(1000*7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 参数回调
     */
    @Test
    public void callBackTest(){
        dubboConsumerTestServiceImpl.callBackTest();
        System.out.println();
    }

   /* @Test
    public void eventNotifyTest() throws InterruptedException, NulidexiaomaException {
        try {
            eventNotifyService.notifyEvent("wenzailong");
            System.out.println("坑了");
            Thread.currentThread().sleep(1000*5);
            *//*throw new NulidexiaomaException("我就是想阿报错");*//*
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    *//*本地存根*//*
    @Test
    public void localTest(){
        try {
            subService.sayHello("本地存根");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    /*本地伪装*/
    @Test
    public void mockTest(){
        try {
            mockService.sayHello("wenzailong");
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void easyDubboTest(){
        MessageInfo messageInfo = dubboProvider.providerTest("wenzailong");
        System.out.println();
    }

}
