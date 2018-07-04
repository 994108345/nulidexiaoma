package cn.wzl.nulidexiaoma.common.mq;/**
 * Created by wenzailong on 2018/7/4.
 */

import com.alibaba.fastjson.JSON;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author wenzailong
 * @create 2018-07-04 16:38
 **/
public class MqUtils {
    /**
     * 创建队列消息
     */
    public static MessageCreator createMsg(final Object o){
        if (null == o) return null;
        return new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                String str;
                if(o instanceof String){
                    str = o.toString();
                }else {
                    str = JSON.toJSONString(o);
                }
                return session.createTextMessage(str);
            }
        };
    }

    /**
     * 根据队列名称发送信息
     */
    public static  void sendMsg(final String destination, final Object msg, JmsTemplate jmsTemplate){
        if (null == msg || null == destination) throw new RuntimeException("destination or msg is null");
        MessageCreator mc = createMsg(msg);
        jmsTemplate.send(new ActiveMQQueue(destination),mc);
    }
}
