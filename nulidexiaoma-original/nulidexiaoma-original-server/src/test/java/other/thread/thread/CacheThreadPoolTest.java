package other.thread.thread;/**
 * Created by wenzailong on 2018/7/24.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wenzailong
 * @create 2018-07-24 16:00
 **/
public class CacheThreadPoolTest {
    private static ExecutorService exe = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            exe.execute(new ThreadPoolTest("i"));
        }
        System.out.println("全部结束了吗");
        exe.shutdown();
        exe.execute(new ThreadPoolTest("11"));
        System.out.println("全部结束了");
    }
    @Test
    public void  callThreadTest() throws ExecutionException, InterruptedException {
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<String> future = exe.submit(new CallThreadTest());
            list.add(future);
        }
        for (Future<String> stringFuture : list) {
            String retStr = stringFuture.get();
            System.out.println("返回结果为：" + retStr);
        }
        exe.shutdown();
    }
}
