package nulidexiaoma.server.test.nulidexioamatest;/**
 * Created by wenzailong on 2018/5/9.
 */

import cn.wzl.nulidexiaoma.api.IMultiThreadingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wenzailong
 * @create 2018-05-09 9:58
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class MultiThreadThreadServiceTest {
    @Autowired
    IMultiThreadingService iMultiThreading;
    @Test
    public void threadInsetTest(){
        try {
            iMultiThreading.threadMathod(10);
            System.out.println("瞅瞅，先睡个十秒吧");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void callBackTest(){
        try {
            iMultiThreading.returnRandom();
            System.out.println("快看随机数");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
