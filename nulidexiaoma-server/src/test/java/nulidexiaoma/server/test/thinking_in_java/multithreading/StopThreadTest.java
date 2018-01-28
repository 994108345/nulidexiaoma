package nulidexiaoma.server.test.thinking_in_java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wenzailong on 2018/1/28.
 */
public class StopThreadTest {
}
class DemoThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0 ; i< 50; i++){
            System.out.println(i);
            if( i == 10){
                Thread.interrupted();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        DemoThread demonThread = new DemoThread();

        Thread thread = new Thread(demonThread);
        thread.start();
        thread.sleep(1000);
        thread.interrupt();
        Thread.currentThread().interrupt();
        Thread t = Thread.currentThread();
        System.out.println(thread.isInterrupted());
        System.out.println(Thread.interrupted());
        System.out.println(t.isInterrupted());
    }
}

class MyThread extends  Thread{
    @Override
    public void run() {
        super.run();
        try {
        for (int i =0;i< 500000;i++){
            if(this.interrupted()){
                System.out.println("已经是停止状态了。我要退出了");
                throw new InterruptedException();
            }
            System.out.println("i=" + (i + 1));
        }
        System.out.println("我被输出，如果代码是for又继续运行，线程并未停止");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("捕获了！");
        }
    }
}
class Run{
    public static void main(String[] srgs){
        try{
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
