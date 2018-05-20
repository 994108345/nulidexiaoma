package thread.ThreadLocal;/**
 * Created by wenzailong on 2018/5/15.
 */

/**
 * @author wenzailong
 * @create 2018-05-15 15:51
 **/
public class ThreadMain {
    public static void main(String[] args) {
        System.out.println("主线程获得的值为：" + Tools.t1.get());
        ThreadA thread1 = new ThreadA();
        ThreadB thread2 = new ThreadB();
        Thread threadA = new Thread(thread1);
        Thread threadB = new Thread(thread2);
        threadA.start();
        threadB.start();
    }
}
