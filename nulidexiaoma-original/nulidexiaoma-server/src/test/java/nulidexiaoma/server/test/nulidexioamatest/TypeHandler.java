package nulidexiaoma.server.test.nulidexioamatest;/**
 * Created by wenzailong on 2018/4/25.
 */

import cn.wzl.nulidexiaoma.common.enums.SexEnum;
import cn.wzl.nulidexiaoma.dao.login.IUserDao;
import cn.wzl.nulidexiaoma.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wenzailong
 * @create 2018-04-25 10:12
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TypeHandler {
    @Autowired
    IUserDao userDao;
    @Test
    public void  insertUserByHandler(){
        try {
            User user = new User();
            user.setName("1111");
            user.setPassWord("2222");
            user.setUserName("3333");
            /*user.setSex(SexEnum.male);*/
            int returnNum = userDao.insertUserByTypeHandler(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void insertUserByRemarkTypeHandler(){
        try {
            User user = new User();
            user.setRemark("1");
            int returnNum = userDao.insertUserByRemarkTypeHandler(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void selectUsr(){
        try {
            User user = new User();
            user.setRemark("1");
            List<User> list = userDao.selectRemarkTypeHandler(user);
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
