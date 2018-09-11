package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.mq.MqUtils;
import cn.wzl.nulidexiaoma.html.api.MqConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by 99410 on 2018/8/31.
 */
@Service
public class MqConsumerServiceImpl implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(MqConsumerServiceImpl.class);
    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            String text = msg.getText();
            Thread.currentThread().sleep(1000*10);
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
