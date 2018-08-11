package thread.lock.pc;/**
 * Created by wenzailong on 2018/5/15.
 */

/**
 * @author wenzailong
 * @create 2018-05-15 17:40
 **/
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        try {
            ThreadA a  = new ThreadA(service);
            ThreadB b = new ThreadB(service);

          Thread threadA = new Thread(a);
          Thread threadB = new Thread(b);
          threadA.setName("Soap");
          threadB.setName("Bath");
          threadA.start();
          threadB.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
