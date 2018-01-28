package nulidexiaoma.server.test.thinking_in_java.multithreading;

import java.sql.Time;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wenzailong on 2018/1/26.
 */
public class DemoThreadTest {
}

class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor(){
        super(0,Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),new DaemonThreadFactory());
    }
}
class Daemon implements  Runnable{
    private Thread[] t = new Thread[10];
    @Override
    public void run() {
        for(int i = 0;i < t.length; i++){
            t[i] =new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn "+ i + " started.");
        }
        for(int i = 0;i < t.length; i++){
            System.out.println("t[ "+ i + " ].isDaemon() = " + t[i].isDaemon());
        }
    }
}

class DaemonSpawn implements Runnable{
    @Override
    public void run() {
        int i = 1;
        while(true){
            System.out.println(i);
            i++;
            Thread.yield();
        }
    }
}
class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ".");
        TimeUnit.SECONDS.sleep(1);
    }

}

/**
 * 主线程是什么线程创建的子线程默认就是什么线程
 */
class ADaemon implements Runnable{

    @Override
    public void run() {
        System.out.println("Starting ASemon");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("this should always run?");
        }
    }
}
class DaemonsDontRunFinally{
    public static void main(String[] arg) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        System.out.println(t.isDaemon());
        t.start();
        TimeUnit.SECONDS.sleep(1);
    }
}