package nulidexiaoma.server.test.thinking_in_java.multithreading;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * Created by wenzailong on 2018/1/24.
 */
public class LiftOff implements  Runnable{
    protected  int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#" + id + "(" + (countDown >0?countDown:"Liftoff!")+ "),";
    }

    @Override
    public void run() {
        Thread a = Thread.currentThread();
        System.out.println(a.isDaemon());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(countDown -->0){
            System.out.println(status());
        }
    }

}

/**
 * 使用CachedThreadPool（在执行过程中创建程序需要的线程数）
 */
class CachedThreadPool{
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i<5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}

/**
 * 使用FixedThreadPool（线程池个数）
 */
class FixedThreadPool{
    public static void main(String[] args){
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for(int i = 0; i<5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}

/**
 * 单例线程池
 */
class SingleThreadExecutor{
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i<5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
        System.out.println("所有线程都结束咯");
    }
}

/**
 * call线程有返回值
 */
class TaskWithResult  implements Callable<String>{

    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult" + id;
    }
}
class CallCbleDemo{
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for(int i =0; i < 10; i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs:results){
            try{
                System.out.println(fs.get());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}



class MainThreadTest{
    public static void main (String[] args){
        LiftOff lauch = new LiftOff();
        lauch.run();
    }
}

class BasicThread{

    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("wating for liftoff");
    }
}

class BasicThreadTest1 implements  Runnable{
    String name ;
    public BasicThreadTest1(String name){
        this.name = name;
        System.out.println(name +"启动了");
    }
    @Override
    public void run() {
        int i = 0;
        while(i<3) {
            System.out.println(name+"调用" +i+"次");
            i++;
            Thread.yield();
        }
        System.out.println(name +"结束了");
    }

}
class MainTrheadRunTest{
    public static void main(String[] args){
        Thread t1 = new Thread(new BasicThreadTest1("A"));
        Thread t2 = new Thread(new BasicThreadTest1("B"));
        Thread t3 = new Thread(new BasicThreadTest1("C"));
        t1.start();
        t2.start();
        t3.start();
    }
}



