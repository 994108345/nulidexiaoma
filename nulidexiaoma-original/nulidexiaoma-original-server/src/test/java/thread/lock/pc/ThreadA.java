package thread.lock.pc;/**
 * Created by wenzailong on 2018/5/16.
 */


/**
 * @author wenzailong
 * @create 2018-05-16 10:30
 **/
public class ThreadA implements Runnable{
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.read();
    }
}
