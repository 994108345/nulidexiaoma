package nulidexiaoma.server.test.nulidexioamatest;/**
 * Created by wenzailong on 2018/7/4.
 */

import cn.wzl.nulidexiaoma.api.MqService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.mq.NormalMqDemo;
import cn.wzl.nulidexiaoma.service.impl.consumer.TestMqConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author wenzailong
 * @create 2018-07-04 15:17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class MQTest {
    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource
    private MqService mqService;
    @Test
    public void sendTest(){
        try {
            String a = "测试数据";
            MessageCreator messageCreator = new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {

                    return session.createTextMessage("aaa");
                }
            };
            jmsTemplate.send(messageCreator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void mqtest(){
        try {
            NormalMqDemo normalMqDemo = new NormalMqDemo();
            normalMqDemo.testMQProducerQueue();
            normalMqDemo.testMQConsumerQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendToMq(){
        try {
            MessageInfo messageInfo = new MessageInfo();
            mqService.sendTestMq("123");
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    public void mqBuMultiThread(){

        for (int i = 0; i < 100; i++) {
            MqThread mqThread = new MqThread("demo"+i);
            Thread thread = new Thread(mqThread);
            thread.start();
            System.out.println("线程"+i);
        }
    }

    class MqThread implements Runnable{
        String name;

        public MqThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            mqService.sendTestMq(name);
        }
    }
}
