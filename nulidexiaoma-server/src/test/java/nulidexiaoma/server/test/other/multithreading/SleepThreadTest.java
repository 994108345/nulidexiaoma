package nulidexiaoma.server.test.other.multithreading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wenzailong on 2018/1/26.
 */
public class SleepThreadTest {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i =0;i<10;i++){
            executorService.execute(new ThredTest());
        }
    }


}
class ThredTest implements Runnable{

    @Override
    public void run() {
        Random random = new Random();
        int sleepNum = (random.nextInt(10)+1);
        try {
            System.out.println("睡眠时间:"+sleepNum);
            Thread.sleep(sleepNum*100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
