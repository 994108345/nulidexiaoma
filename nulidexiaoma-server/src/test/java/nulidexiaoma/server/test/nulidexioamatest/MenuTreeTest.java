package nulidexiaoma.server.test.nulidexioamatest;

import cn.wzl.nulidexiaoma.api.IMenuService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.model.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzailong on 2018/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class MenuTreeTest {
    private Logger logger = LoggerFactory.getLogger(MenuTreeTest.class);
    @Resource
    IMenuService menuService;
    @Test
    public void menuTreeTest(){
        try {
            MessageInfo messageInfo = new MessageInfo();
            Menu menu = new Menu();
            messageInfo = menuService.selectAllList(menu);
            messageInfo.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("错了");
        }
    }

    @Test
    public void addMenuTest(){
        MessageInfo messageInfo = new MessageInfo();
        Menu menu = new Menu();
        menu.setMenuName("demo测试");
        List list = new ArrayList<>();
        list.add(menu);
        list.add(menu);
        list.add(menu);

        try {
            messageInfo = menuService.insertList(list);
            messageInfo.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test12(){
        int i = 0;
        System.out.println((++i)+"");
    }

}
