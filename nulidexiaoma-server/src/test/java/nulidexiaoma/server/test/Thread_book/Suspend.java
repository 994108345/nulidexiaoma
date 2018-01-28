package nulidexiaoma.server.test.Thread_book;

import com.sun.jmx.snmp.internal.SnmpSubSystem;

import java.util.concurrent.ThreadFactory;

/**
 * Created by wenzailong on 2018/1/28.
 */
public class Suspend {
}

class SuspendTest extends Thread{
    private long i = 0;
    public long getI(){
        return i;
    }
    public void setI(long i){
        this.i = i;
    }

    @Override
    public void run() {
        while(true){
            i++;
        }
    }
}
class SuspendRun{
    public static void main(String[] args) throws InterruptedException {
        SuspendTest suspendTest = new SuspendTest();
        suspendTest.start();
        Thread.sleep(5000);
        suspendTest.suspend();
        System.out.println("A = "+System.currentTimeMillis() + " i=" + suspendTest.getI());
        Thread.sleep(5000);
        System.out.println("A=" +System.currentTimeMillis() + " i=" + suspendTest.getI());
        suspendTest.resume();
        Thread.sleep(5000);
        suspendTest.suspend();
        System.out.println("B = "+System.currentTimeMillis() + " i=" + suspendTest.getI());
        Thread.sleep(5000);
        System.out.println("B=" +System.currentTimeMillis() + " i=" + suspendTest.getI());

    }
}

class SynchronizedObject{
    synchronized  public void printString(){
        System.out.println("begin");
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("a 线程永远 suspend了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
class Run1{
    public static void main(String[] args){
        try{
            final SynchronizedObject object = new SynchronizedObject();
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    object.printString();
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    System.out.println("thread2启动了，但进不了printString()方法！只打印1个begin");
                    System.out.println("因为printString()方法被a线程锁定并且永远suspend暂停了！");
                    object.printString();
                }
            };
            thread2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class MyThreads extends  Thread{
    private long i = 0;

    @Override
    public void run() {
        while(true){
            i++;
            System.out.println(i);
        }
    }
}
class Run2{
    public static void main(String[] args){
        try{
            MyThreads myThreads = new MyThreads();
            myThreads.start();
            Thread.sleep(10);
            myThreads.suspend();
            System.out.println("main end!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

 class MyObject{
    private String userName = "1";
    private String password ="11";
    public void setValue(String u,String p){
        this.userName = u;
        if(Thread.currentThread().getName().equals("a"));{
            System.out.println("停止A线程！");
            Thread.currentThread().suspend();
        }
        this.password = p;
    }
    public void printUsernamePassword(){
        System.out.println(userName + " " + password);
    }
}

class Run3{
    public static void main(String[] args) throws InterruptedException {
        final MyObject myObject = new MyObject();
        Thread thread = new Thread(){
            @Override
            public void run() {
                myObject.setValue("a","aa");
            }
        };
        thread.setName("a");
        thread.start();
        Thread.sleep(500);
        Thread thread2 =  new Thread(){
            public void run(){
                myObject.printUsernamePassword();
            }
        };
        thread2.start();

    }
}