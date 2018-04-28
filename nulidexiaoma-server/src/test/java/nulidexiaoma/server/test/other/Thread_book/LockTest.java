package nulidexiaoma.server.test.other.Thread_book;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wenzailong on 2018/2/1.
 */
public class LockTest {

}
class LockService{
    private Lock lock = new ReentrantLock();
    public void testMrthod(){
        lock.lock();
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        lock.unlock();
    }
}

class LockThread extends  Thread{
    private LockService lockService;

    public LockThread(LockService lockService) {
        this.lockService = lockService;
    }

    @Override
    public void run() {
        lockService.testMrthod();
    }
}
class LockRun{
    public static void main(String[] args) {
        LockService lockService = new LockService();
        LockThread a = new LockThread(lockService);
        a.setName("A");
        a.start();
        LockThread b = new LockThread(lockService);
        b.setName("B");
        b.start();
    }
}
class ConditionService{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValur = false;
    public void set(){
        try {
            lock.lock();
            while(hasValur == false){
                condition.await();
            }
            System.out.println("打印A");
            hasValur = false;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void get(){
        try {
            lock.lock();
            while(hasValur == true){
                condition.await();
            }
            System.out.println("打印B");
            hasValur = true;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
class ConditionThreadA extends Thread{
    ConditionService conditionService = new ConditionService();

    public ConditionThreadA(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            conditionService.get();
        }
    }
}
class ConditionThreadB extends Thread{
    ConditionService conditionService = new ConditionService();

    public ConditionThreadB(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            conditionService.set();
        }
    }
}
class RunCondition{
    public static void main(String[] args) {
        ConditionService conditionService = new ConditionService();
        ConditionThreadA[] a = new ConditionThreadA[10];
        ConditionThreadB[] b = new ConditionThreadB[10];
        for (int i = 0; i < 10; i++) {
            b[i] = new ConditionThreadB(conditionService);
            a[i] = new ConditionThreadA(conditionService);
            a[i].start();
            b[i].start();
        }
    }
}

class InterruptedSerice{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void method(){
        try {
            lock.lock();
            System.out.println("Thread");
            condition.awaitUntil(new Date(12));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
class ThreadInterrupted extends  Thread{
    private InterruptedSerice interruptedSerice = new InterruptedSerice();

    public ThreadInterrupted(InterruptedSerice interruptedSerice) {
        this.interruptedSerice = interruptedSerice;
    }

    @Override
    public void run() {
        interruptedSerice.method();
    }
}
class RunInterrupted{
    public static void main(String[] args) throws InterruptedException {
        InterruptedSerice interruptedSerice = new InterruptedSerice();
        ThreadInterrupted a = new ThreadInterrupted(interruptedSerice);
        a.start();
        a.sleep(200);
        a.interrupt();
        System.out.println("结束");
    }
}