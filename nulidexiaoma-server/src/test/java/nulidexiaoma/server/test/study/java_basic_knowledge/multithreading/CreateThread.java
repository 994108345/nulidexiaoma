package nulidexiaoma.server.test.study.java_basic_knowledge.multithreading;

import nulidexiaoma.server.test.nulidexioamatest.LoginServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzailong on 2018/1/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class CreateThread {
    private Logger logger = LoggerFactory.getLogger(LoginServiceTest.class);
    /*
    创建多线程主要分为两种方式，第一种为继承Thread类。第二种为实现Runnable接口
     */

    /*调用“继承Thread类创建线程”*/
    @Test
    public void createByThredTest(){
        CreateByThred thread1 = new CreateByThred("A");
        CreateByThred thread2 = new CreateByThred("B");
        thread1.start();//调用此方法时，会自动调用线程类的run()方法。
        thread2.start();
    }
    /**
     * 继承Thread类创建线程
     */
    class CreateByThred extends Thread{
        String name;
        public CreateByThred(String name){
            this.name = name;
        }

        /*线程会交替执行该方法*/
        public void run(){
            for(int i = 0;i<100;i++){
                System.out.println(name+":"+i);
            }
        }
    }

    /*调用“实现Runnable接口”*/
    @Test
    public void createByRunnableTest(){
        CreateThreadByRunnable thread1 = new CreateThreadByRunnable("c");
        CreateThreadByRunnable thread2 = new CreateThreadByRunnable("d");
        Thread threads1= new Thread(thread1);
        Thread threads2= new Thread(thread2);
        threads1.start();//调用此方法时，会自动调用线程类的run()方法。
        threads2.start();

    }
    /**
     * 实现Runnable接口
     */
    class CreateThreadByRunnable implements Runnable{
        String name;
        public CreateThreadByRunnable(String name){
            this.name = name;
        }

        @Override
        public void run() {
            for(int i = 0;i<100;i++){
                System.out.println(name+":"+i);
            }
        }
    }


    /**
     * 测试join方法
     */
    class ThredJoin implements  Runnable{
        String name;
        public ThredJoin(String name){
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(name+":子线程开始了");
            for(int i = 0;i<20;i++){
                System.out.println(name+":"+i);
            }
            System.out.println(name+":子线程结束了");
        }
    }
    /**
     * 测试josin方法
     * @throws InterruptedException
     */
    @Test
    public void threadJoinTest() throws InterruptedException {
        System.out.println("主线程开始了");
        ThredJoin threadJoin1 = new ThredJoin("A");
        ThredJoin threadJoin2 = new ThredJoin("B");
        Thread thread1 = new Thread(threadJoin1);
        Thread thread2 = new Thread(threadJoin2);
        thread1.start();
        thread2.start();
        thread1.join();//当thread线程运行结束的时候，才会执行以下代码！
        System.out.println("主线程结束了");


    }

    /**
     * 测试yield()
     */
    class yieldThread implements Runnable{

        String name;
        public yieldThread(String name){
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(name+":子线程开始了");
            for(int i = 0;i<20;i++){
                System.out.println(name+":"+i);
            }
            System.out.println(name+":子线程结束了");
        }
    }
    /**
     * 测试yield方法
     * @throws InterruptedException
     */
    @Test
    public void yieldThreadTest() throws InterruptedException {
        System.out.println("主线程开始了");
        yieldThread threadJoin1 = new yieldThread("A");
        yieldThread threadJoin2 = new yieldThread("B");
        Thread thread1 = new Thread(threadJoin1);
        Thread thread2 = new Thread(threadJoin2);
        thread1.start();
        thread2.start();
        thread1.yield();//使该进程进入可运行状态，它把运行机会让给了同等优先级的其他线程，但是具体谁活的cpu还是随机的！
        System.out.println("停止A线程");
        System.out.println("主线程结束了");


    }


    /**
     * 测试锁对象
     */
    class SynchronizedTest implements Runnable{
        private String name;
        private Object prev;
        private Object self;
        private SynchronizedTest(String name,Object prev,Object self){
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while(count >0) {

                synchronized (prev) {

                    synchronized (self) {
                        System.out.print(name);
                        count--;
                        self.notify();
                    }
                    try {
                        prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    @Test
    public void synchronizedTest(){
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        SynchronizedTest t1 = new SynchronizedTest("A",c,a);
        SynchronizedTest t2 = new SynchronizedTest("B",a,b);
        SynchronizedTest t3 = new SynchronizedTest("C",b,c);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);
        thread1.start();
        thread2.start();
        thread3.start();
    }


    /**
     * 单锁
     */
    @Test
    public void singleSynchronizedTest(){
        DemoTest demoTest = new DemoTest();
        ThreadTest threadTest1 = new ThreadTest(demoTest,"a");
        ThreadTest threadTest2 = new ThreadTest(demoTest,"b");
        Thread thread1 = new Thread(threadTest1);
        Thread thread2 = new Thread(threadTest2);
        thread1.start();
        thread2.start();
    }
    class DemoTest{
         public void add(String username){
             int num = 0;
            try{
                if(username.equals("a")){
                    num = 100;
                    System.out.println("a set over");
                    Thread.sleep(1000);
                }else{
                    num = 200;
                    System.out.println("b set over!");
                    Thread.sleep(1000);
                }
                System.out.println(username + " num=" + num);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    class ThreadTest implements Runnable{
        DemoTest demoTest ;
        String name;

        public ThreadTest(DemoTest demoTest,String name){
            this.name =name;
            this.demoTest = demoTest;
        }
        @Override
        public void run() {
            demoTest.add(name);
        }
    }
}

class Test2 {
    public static void main(String[] args){
        /*ExecutorService exception = Executors.newCachedThreadPool();
        exception.execute(new Thread2("A"));
        exception.execute(new Thread2("B"));
        exception.shutdown();*/
        List list = new ArrayList<>();
        Thread2 t1 = new Thread2("A",list);
        Thread2 t2 = new Thread2("b",list);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
class Thread2 implements Runnable{
    String name;
    List a ;

    public Thread2(String name,List a) {
        this.name = name;
         this.a = a;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            a.add(i);
            System.out.println(name +":--i.size()="+a.size());
            System.out.println(name +":"+i);
        }
    }
}



