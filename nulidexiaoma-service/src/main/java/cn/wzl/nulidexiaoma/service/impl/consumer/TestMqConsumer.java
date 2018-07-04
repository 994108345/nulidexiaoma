package cn.wzl.nulidexiaoma.service.impl.consumer;/**
 * Created by wenzailong on 2018/7/4.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author wenzailong
 * @create 2018-07-04 17:37
 **/
public class TestMqConsumer implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(TestMqConsumer.class);
    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            String text = msg.getText();
            logger.error("测试队列消费者消费TEXT_MQ成功，内容为：" + text);
        } catch (JMSException e) {
            e.printStackTrace();
            logger.error("测试队列消费TEXT_MQ失败：" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("测试队列消费TEXT_MQ失败：" + e.getMessage());
        }
    }
}
