package nulidexiaoma.server.test.nulidexioamatest.controller;/**
 * Created by wenzailong on 2018/8/13.
 */

import cn.wzl.nulidexiaoma.model.User;
import cn.wzl.nulidexiaoma.original.web.LoginController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wenzailong
 * @create 2018-08-13 19:58
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ControllerTest {
    @Autowired
    private LoginController loginController;
    @Test
    public void loginTest(){
        User user = new User();
        user.setUserName("123");
        user.setPassWord("123");
        loginController.login(user);
        System.out.println();
    }
}
