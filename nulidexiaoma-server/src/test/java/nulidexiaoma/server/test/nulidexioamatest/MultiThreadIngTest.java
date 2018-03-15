package nulidexiaoma.server.test.nulidexioamatest;

import cn.wzl.nulidexiaoma.api.IMultiThreadingService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.dao.multithreading.IMultiThreadingDao;
import cn.wzl.nulidexiaoma.dao.multithreading.IThreadTestDao;
import cn.wzl.nulidexiaoma.model.MultiThreading;
import cn.wzl.nulidexiaoma.model.ThreadTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wenzailong on 2018/3/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class MultiThreadIngTest {
    @Autowired
    IMultiThreadingDao iMultiThreadingDao;

    @Autowired
    IThreadTestDao iThreadTestDao;

    @Autowired
    IMultiThreadingService iMultiThreadingService;

    @Test
    public void select(){

        try {
            MessageInfo messageInfo = new MessageInfo<>();
            List<MultiThreading> list = iMultiThreadingDao.selectAllDate();
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void updateList(){
        MultiThreading multiThreading = new MultiThreading();
        MultiThreading multiThreading1 = new MultiThreading();

        multiThreading.setId(2);
        multiThreading.setControlNum("7");
        multiThreading.setThreadName("线程1");

        multiThreading1.setId(3);
        multiThreading1.setControlNum("8");
        multiThreading1.setThreadName("线程2");

        List<MultiThreading> list = new ArrayList();
        list.add(multiThreading);
        /*list.add(multiThreading1);*/
        try {
            int resultNum = iMultiThreadingDao.updateMultiThreading(list);
            System.out.println(resultNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateThreadTest(){
        List<ThreadTest> list = new ArrayList();
        ThreadTest test = new ThreadTest();
        ThreadTest test1 = new ThreadTest();
        test.setName("4");
        test.setThradId(2);
        test1.setName("5");
        test1.setThradId(3);
        list.add(test);
        list.add(test1);
        try {
            iThreadTestDao.updateThreadInfo(list);
            /*iThreadTestDao.updateOne(test);*/
            System.out.println("成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void normalTimeTest(){

        try {
            MessageInfo messageInfo = iMultiThreadingService.normalMathod();
            System.out.println(messageInfo.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void threadTimeTest(){

        try {
            MessageInfo messageInfo = iMultiThreadingService.threadMathod(10);
            System.out.println(messageInfo.getMessage());
            Thread.currentThread().sleep(1000*20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sout(){
        for (int i = 0; i < 10; i++) {
            System.out.println("循环啊：" + i);
        }

    }

}
class TaskWithResule implements Callable<String>{
    private int id;
    public  TaskWithResule(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        MultiThreadIngTest multiThreadIngTest = new MultiThreadIngTest();
        multiThreadIngTest.sout();
        return "result of TaskWithReslt"+id;
    }
}

class CallableDemo{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResule(i)));
        }
        for (Future<String> fs:results) {

            try {
                fs.get();
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }
}
