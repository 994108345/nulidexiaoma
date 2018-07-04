package cn.wzl.nulidexiaoma.common.mq;/**
 * Created by wenzailong on 2018/7/4.
 */

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;

/**
 * @author wenzailong
 * @create 2018-07-04 15:05
 **/
public class JmsMessageSender {
    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * send text to default destination
     * @param text
     */
    public void send(final String text)
    {
        this.jmsTemplate.send(new MessageCreator()
        {
            @Override
            public Message createMessage(Session session) throws JMSException
            {
                Message message = session.createTextMessage(text);
                message.setJMSReplyTo(new ActiveMQQueue("Recv2Send"));
                return message;
            }
        });
    }

    /**
     * Simplify the send by using convertAndSend
     * @param text
     */
    public void sendText(final String text)
    {
        this.jmsTemplate.convertAndSend(text);
    }

    /**
     * Send text message to a specified destination
     * @param dest
     * @param text
     */
    public void send(final Destination dest, final String text)
    {
        this.jmsTemplate.send(dest, new MessageCreator()
        {
            @Override
            public Message createMessage(Session session) throws JMSException
            {
                Message message = session.createTextMessage(text);
                return message;
            }
        });
    }

    public void send(final Object hi)
    {
        jmsTemplate.send(new MessageCreator()
        {
            @Override
            public Message createMessage(Session session) throws JMSException
            {
                return session.createObjectMessage((Serializable) hi);
            }
        });
    }
}
