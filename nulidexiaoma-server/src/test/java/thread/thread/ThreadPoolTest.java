package thread.thread;/**
 * Created by wenzailong on 2018/7/24.
 */

/**
 * @author wenzailong
 * @create 2018-07-24 16:02
 **/
public class ThreadPoolTest implements Runnable {
    String threadName;

    public ThreadPoolTest(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        int b = 0;
        for (int i = 0; i < 10000; i++) {
            b = b +i;
        }
        System.out.println(Thread.currentThread().getName()+".b:" + b);
    }
}
