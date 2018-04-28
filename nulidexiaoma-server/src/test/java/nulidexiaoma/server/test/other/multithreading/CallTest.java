package nulidexiaoma.server.test.other.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wenzailong on 2018/1/26.
 */
public class CallTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> list = new ArrayList<Future>();
        for(int i = 0;i<10;i++){
            list.add(executorService.submit(new CallThreadTest()));
        }
        for(int i = 0; i < list.size();i++){
            Future future = list.get(i);
            while(!future.isDone()){
                System.out.println("还没处理完！");
            }
                int a = (int) future.get();
                System.out.println(a);
        }

    }


}

/**
 * 返回值call
 */
class CallThreadTest implements Callable<Integer>{

    public CallThreadTest(){
    }


    @Override
    public Integer call() throws Exception {
        int result = 0;
        Random random = new Random();
        int n = random.nextInt(10)+1;
        for(int i =0;i < n;i++){
            result = result+i;
        }
        return result;
    }
}
