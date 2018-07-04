package cn.wzl.nulidexiaoma.common.mq;/**
 * Created by wenzailong on 2018/7/4.
 */

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;

/**
 * @author wenzailong
 * @create 2018-07-04 15:08
 **/
public class JmsMessageReceiver {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "Send2Recv")
//    @SendTo("Recv2Send")
    public void onMessage(String text) throws JMSException
    {
        System.out.println("Received: " + text );
    }
}
