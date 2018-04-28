package nulidexiaoma.server.test.nulidexioamatest;/**
 * Created by wenzailong on 2018/4/25.
 */

import cn.wzl.nulidexiaoma.dao.cascade.IClassDao;
import cn.wzl.nulidexiaoma.dao.cascade.IStuCardDao;
import cn.wzl.nulidexiaoma.dao.cascade.IStudentDao;
import cn.wzl.nulidexiaoma.model.StuCard;
import nulidexiaoma.server.test.other.dynamicproxy.HelloServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wenzailong
 * @create 2018-04-25 17:47
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class Cascade {
    private static final Logger logger = LoggerFactory.getLogger(Cascade.class);
    @Autowired
    IStudentDao iStudentDao;
    @Autowired
    IStuCardDao iStuCardDao;
    @Autowired
    IClassDao iClassDao;
    @Test
    public void oneToOne(){
        try {
            StuCard stuCard = new StuCard();
            List<StuCard> resultList = iStuCardDao.getStuCardById(1);
            System.out.println(resultList.size());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void oneToMany(){
        try {
            List resultList = iClassDao.getClassById(1);
            System.out.println(resultList.size());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void discriminator(){
        try {
            List resultList = iStudentDao.getStudentByDiscriminator(1);
            System.out.println(resultList.size());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void firCecheTest(){
        try {
            List resultList1 = iClassDao.getClassByFirLevelCache(1);
            logger.info("第一次调用");
            List resultList2 = iClassDao.getClassByFirLevelCache(1);
            logger.info("第二次调用");
            System.out.println(resultList1.size());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void proxy(){
        Object o = new HelloServiceImpl();
       Class<?>[] aClass =  o.getClass().getInterfaces();
        for (Class<?> aClass1 : aClass) {
            System.out.println(aClass1);
        }
        ClassLoader classLoader = o.getClass().getClassLoader();
        System.out.println(classLoader);
    }
}
