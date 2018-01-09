package nulidexiaoma.server.test;

import cn.wzl.nulidexiaoma.model.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzailong on 2017/12/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ToolsTest {
    private Logger logger = LoggerFactory.getLogger(LoginServiceTest.class);

    @Test
    public void objectToJson(){
        User user = new User();
        user.setUserName("123");
        user.setPassWord("123");
        String str=JSON.toJSONString(user);
        System.out.println(str);

    }
    @Test
    public void listTest(){
        List list = new ArrayList<>();
        list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");
        list.add("2");list.add("2");list.add("2");list.add("2");list.add("2");list.add("2");list.add("2");list.add("2");
        List sublist = list.subList(0,16);
        System.out.println(sublist.toString());
    }
}
