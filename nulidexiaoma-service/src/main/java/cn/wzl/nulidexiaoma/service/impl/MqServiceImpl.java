package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/7/4.
 */

import cn.wzl.nulidexiaoma.api.MqService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.mq.MqUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author wenzailong
 * @create 2018-07-04 17:08
 **/
@Service("mqService")
public class MqServiceImpl implements MqService {
    private static final Logger logger = LoggerFactory.getLogger(MqServiceImpl.class);
    @Resource(name = "testQueue")
    private Destination testQueue;
    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;
    @Override
    public MessageInfo sendTestMq(String mqStr) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            MessageCreator mqMsg = MqUtils.createMsg(mqStr);
            jmsTemplate.send(testQueue,mqMsg);
            logger.error("推入TEXT_MQ成功:");
        } catch (Exception e) {
            logger.error("推入testQueue出错:"+e.getMessage());
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"推入testQueue出错:"+e.getMessage());
        }
        return messageInfo;
    }
}
