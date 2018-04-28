package nulidexiaoma.server.test.other.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wenzailong on 2018/1/26.
 */
public class PrioritiesTest implements  Runnable{
    int priority;
    public PrioritiesTest(int maxPriority) {
        this.priority = maxPriority;
    }

    public static void main (String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i< 5; i++){
            executorService.execute(new PrioritiesTest(Thread.MIN_PRIORITY));
        }
        for(int i = 0; i< 5; i++){
            executorService.execute(new PrioritiesTest(Thread.MAX_PRIORITY));
        }
        executorService.shutdown();
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        int priority = Thread.currentThread().getPriority();
        System.out.println(Thread.currentThread()+"优先级为：" + priority);
    }
}
class SimplePriOrities{

}
