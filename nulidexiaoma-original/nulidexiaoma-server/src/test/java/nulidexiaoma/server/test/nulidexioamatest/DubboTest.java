package nulidexiaoma.server.test.nulidexioamatest;/**
 * Created by wenzailong on 2018/7/31.
 */

import cn.wzl.nulidexiaoma.api.DubboConsumerTestService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.html.api.DubboProviderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wenzailong
 * @create 2018-07-31 19:24
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class DubboTest {
    @Autowired
    DubboProviderService dubboProviderServiceImpl;
    @Autowired
    DubboConsumerTestService dubboConsumerTestServiceImpl;
    @Test
    public void provider(){
        try {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo = dubboConsumerTestServiceImpl.consumerTest("wenzailong");
            System.out.println(messageInfo.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
