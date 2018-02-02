package nulidexiaoma.server.test.Thread_book;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wenzailong on 2018/2/1.
 */
public class TimerTaskTest {
}

class RunTimer{
    private static Timer timer = new Timer();
    static class TimerTask extends java.util.TimerTask{

        @Override
        public void run() {
            System.out.println("运行了！时间为：" + new Date());
        }
    }
    public static void main(String[] args) throws ParseException {
        TimerTask task = new TimerTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataString = "2018-02-01 16:15:00";
        Date dateRef = sdf.parse(dataString);
        System.out.println("字符串时间为" + dateRef.toLocaleString() + "当前时间：" + new Date().toLocaleString());
        timer.scheduleAtFixedRate(task,dateRef,1000);
    }
}
class TestA extends Thread{
    public  static class Demo{
        private  static TestA i = new TestA();
    }
    @Override
    public void run() {
        TestA a = Demo.i;
        System.out.println(a.hashCode());
    }

    public static void main(String[] args) {
        TestA a = new TestA();
        TestA b = new TestA();
        TestA c = new TestA();
        TestA d = new TestA();
        TestA e = new TestA();
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}

class SortThread extends Thread{
    private  Object lock;
    private  String showChar;
    private  int showNumPosition;
    private  int printCount = 0;
    volatile  private static int addNumber = 1;

    public SortThread(Object lock, String showChar, int showNumPosition) {
        this.lock = lock;
        this.showChar = showChar;
        this.showNumPosition = showNumPosition;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                while (true){
                    if (addNumber % 3 == showNumPosition) {
                        System.out.println("ThreadName=" + Thread.currentThread().getName()
                                + " runCount=" + addNumber
                                + " " + showChar);
                        lock.notifyAll();
                        addNumber++;
                        printCount++;
                        if (printCount == 3){
                            break;
                        }
                    }else{
                        lock.wait();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class RunSort{
    public static void main(String[] args) {
        Object lock = new Object();
        SortThread a = new SortThread(lock,"A",1);
        SortThread b = new SortThread(lock,"B",2);
        SortThread c = new SortThread(lock,"C",0);
        a.start();
        b.start();
        c.start();
    }
}
class ThreadCount extends Thread{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private ThreadCount threadCount ;

    public ThreadCount(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        this.method();
        this.unLock();
    }
    public void method(){
        lock.lock();
        lock.unlock();
        lock.lock();
        lock.lock();
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ":" + lock.getHoldCount());
    }
    void unLock(){
        lock.unlock();
    }
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ThreadCount a = new ThreadCount(lock);
        ThreadCount b = new ThreadCount(lock);
        ThreadCount c = new ThreadCount(lock);
        ThreadCount d = new ThreadCount(lock);
        ThreadCount e = new ThreadCount(lock);
        a.setName("A");
        b.setName("B");
        c.setName("C");
        d.setName("D");
        e.setName("E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
}
