package thread.thread;/**
 * Created by wenzailong on 2018/7/24.
 */


import java.util.concurrent.Callable;

/**
 * @author wenzailong
 * @create 2018-07-24 16:19
 **/
public class CallThreadTest implements Callable<String> {


    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }
}
