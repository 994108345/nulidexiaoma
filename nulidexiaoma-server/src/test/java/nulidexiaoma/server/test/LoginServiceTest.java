package nulidexiaoma.server.test;


import cn.wzl.nulidexiaoma.api.ILoginService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class LoginServiceTest {
    private Logger logger = LoggerFactory.getLogger(LoginServiceTest.class);
    @Resource
    ILoginService loginService;

    @Test
    public void loginTest(){
        User user = new User();
        user.setUserName("123");
        user.setPassWord("123");
        MessageInfo messageInfo = new MessageInfo();
        try{
            messageInfo = loginService.selectUser(user);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("errorMessage:111111111111111111111111111111111111111111111111111111111");
            logger.info("information:2222222222222222222222222222222222222222222222222222222222");
        }
        logger.info("success33333333333333333333333333333333333333333333333333333333333333333333333");
    }

    @Test
    public void test1(){
        System.out.print("1");
    }
}
