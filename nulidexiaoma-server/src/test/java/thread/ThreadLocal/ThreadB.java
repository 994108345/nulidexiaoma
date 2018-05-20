package thread.ThreadLocal;/**
 * Created by wenzailong on 2018/5/15.
 */

/**
 * @author wenzailong
 * @create 2018-05-15 15:46
 **/
public class ThreadB implements  Runnable{
    @Override
    public void run() {
        try{
            for (int i = 0; i < 100; i++) {
                System.out.println(Tools.t1.get());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
