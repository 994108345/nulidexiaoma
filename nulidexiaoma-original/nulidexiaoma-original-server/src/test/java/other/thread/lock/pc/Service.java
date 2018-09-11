package other.thread.lock.pc;/**
 * Created by wenzailong on 2018/5/16.
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wenzailong
 * @create 2018-05-16 8:45
 **/
public class Service {
    public ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(){
        try{
            try{
                lock.readLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(1000*3);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
               lock.readLock().unlock();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void write(){
        try{
            try{
                lock.writeLock().lock();
                System.out.println("获得写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(1000*3);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.writeLock().unlock();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
