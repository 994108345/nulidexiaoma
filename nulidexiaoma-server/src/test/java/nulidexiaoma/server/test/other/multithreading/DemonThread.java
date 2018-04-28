package nulidexiaoma.server.test.other.multithreading;

import java.util.concurrent.*;

/**
 * Created by wenzailong on 2018/1/26.
 */

/**
 * 可以设置当前线程是否为后台线程！如果为后台线程，当所有的非后台线程结束时，后台线程也就结束了。只要有费后台线程，程序就不会终止！
 */
public class DemonThread implements  Runnable {
    public static void main (String[] args) throws InterruptedException {
        for(int i = 0;i < 10; i++){
            System.out.println(i);
            DemonThread demonThread = new DemonThread();
            Thread thread = new Thread(demonThread);
            //true设置为后台线程、false为非后台线程，main方法默认为非后台线程。
            thread.setDaemon(false);
            thread.start();
            TimeUnit.SECONDS.sleep(5);
        }
        System.out.println("All daemons started");
    }
    @Override
    public void run() {
        int i = 1;
        try{
            while(true){
                System.out.println(Thread.currentThread()+" "+ this+";----"+i);
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("sleep() interrupted");
        }
    }
}
