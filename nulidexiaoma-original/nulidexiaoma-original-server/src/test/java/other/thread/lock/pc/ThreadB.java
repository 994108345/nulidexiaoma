package other.thread.lock.pc;/**
 * Created by wenzailong on 2018/5/16.
 */

/**
 * @author wenzailong
 * @create 2018-05-16 10:30
 **/
public class ThreadB implements Runnable{
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
