package nulidexiaoma.server.test.nulidexioamatest;


import cn.wzl.nulidexiaoma.api.ILoginService;
import cn.wzl.nulidexiaoma.api.IMenuService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.model.Menu;
import cn.wzl.nulidexiaoma.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class LoginServiceTest {
    private Logger logger = LoggerFactory.getLogger(LoginServiceTest.class);
    @Resource
    ILoginService loginService;
    @Resource
    IMenuService menuService;

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

    @Test
    public void addUser() throws InterruptedException {
        AddUserThread a = new AddUserThread();
        AddUserThread b = new AddUserThread();
        a.setName("A");
        a.start();
        a.sleep(5000);
        b.setName("B");
        b.start();
    }

    class AddUserThread extends Thread{
        int i = 0;
        @Override
        public void run() {
           for(int i = 0; i<5;i++){
               insertMenu();
               System.out.println(Thread.currentThread().getName()+":"+i);
           }
        }
    }

    /**
     * 插入
     */
    public void insertMenu(){
        MessageInfo messageInfo = new MessageInfo();
        Menu menu = new Menu();
        menu.setMenuName("demo测试");
        List list = new ArrayList<>();
        list.add(menu);

        try {
            messageInfo = menuService.insertList(list);
            messageInfo.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
class AddUserThread extends Thread{
    public static void main(String[] args){
        System.out.println("开始测试的dimend"+Thread.currentThread().isDaemon());
        AddUserThread a = new AddUserThread();
        AddUserThread b = new AddUserThread();
        a.setName("A");
        a.start();
        b.setName("B");
        b.start();
    }
    int i = 0;
    @Override
    public void run() {
        while (i<3){
            System.out.println("开始测试的dimend"+Thread.currentThread().isDaemon());
            System.out.println(Thread.currentThread().getName() + i);
            i++;
        }
    }
}
