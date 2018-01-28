package nulidexiaoma.server.test.thinking_in_java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 捕获线程异常
 */
public class ExceprionTest implements  Runnable {
    @Override
    public void run() {
        System.out.println("has noException");
        int i = 1/0;
        System.out.println("has exception");
    }
    public static void main (String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceprionTest());
        executorService.shutdown();
    }

}

class ExceptionThread2 implements  Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
class MyUncaughExceptionHandler implements  Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}
class HandlerThreadFactory implements ThreadFactory{
    public Thread newThread(Runnable r){
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("create " + t);
        t.setUncaughtExceptionHandler(
                new MyUncaughExceptionHandler()
        );
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

class CaptureUncaughtException{
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool(
                new HandlerThreadFactory()
        );
        executorService.execute(new ExceptionThread2());
    }

}
