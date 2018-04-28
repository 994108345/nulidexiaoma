package nulidexiaoma.server.test.other.Thread_book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzailong on 2018/1/30.
 */
public class DirtyReadTest {
}
class PublicVar{
    public String username = "A";
    public String password = "AA";
    synchronized public void setValue(String username,String password){


        try{
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name=" + Thread.currentThread().getName()
                    + " username=" + username
                    +" password =" + password);
            setValue(username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    synchronized public void getValue(){
        System.out.println("getValue method thread name=" + Thread.currentThread().getName()
                + " username=" + username
                +" password =" + password);
    }
}
class ThreadA_1 extends Thread{
    private PublicVar publicVar;
    public ThreadA_1(PublicVar publicVar){
        this.publicVar = publicVar;
    }
    @Override
    public void run() {
        publicVar.setValue("B","BB");
    }
    public void getValue(){
        publicVar.getValue();
    }
}
class Test_1{
    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        ThreadA_1 threadA_1 = new ThreadA_1(publicVar);
        threadA_1.start();
        Thread.sleep(200);
        publicVar.getValue();
    }
}

class Task{
    private String getData1;
    private String  getData2;
    public synchronized  void dolongTimeTask() throws InterruptedException {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "长时间处理任务后从远程返回的值1 threadName= " + Thread.currentThread().getName();
            getData2 = "长时间处理任务后从远程返回的值2 threadName= " + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
    }
}
class MyThreadd1 extends Thread {
    private Task task;

    public MyThreadd1(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime1 = System.currentTimeMillis();
        try {
            task.dolongTimeTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
class MyThreadd2 extends Thread{
    private Task task;

    public MyThreadd2(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime1 = System.currentTimeMillis();
        try {
            task.dolongTimeTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
class Rund{
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        MyThreadd1 threadd1 = new MyThreadd1(task);
        threadd1.start();
        MyThreadd2 threadd2 = new MyThreadd2(task);
        threadd2.start();
        Thread.sleep(10000);
        long beginTime = CommonUtils.beginTime1;
        if( CommonUtils.beginTime2 <  CommonUtils.beginTime1){
            beginTime =  CommonUtils.beginTime2;
        }
        long endTime =  CommonUtils.endTime1;
        if( CommonUtils.endTime2 <  CommonUtils.endTime1){
            endTime =  CommonUtils.endTime2;
        }
        System.out.println("耗时： " + ((endTime - beginTime)/1000));

    }
}
class CommonUtils{
    public static long beginTime1;
    public static long beginTime2;
    public static long endTime1;
    public static long endTime2;
}



class MyList{
    private List list = new ArrayList<>();

    public List getList() {
        return list;
    }

    public void add(){
        list.add("高洪岩");
    }
    public int size(){
        return list.size();
    }
}
class ThreadListA extends Thread{
    private MyList list;

    public ThreadListA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try{
            for(int i =0; i< 10; i++){
                list.add();
                if(i == 4){
                    synchronized (list){
                        list.notify();
                    }
                }
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class ThreadListB extends Thread{
    private MyList list;

    public ThreadListB(MyList list) {
        this.list = list;
    }
    @Override
    public void run() {
        try{
            while(true){
                System.out.println("当前集合长度为：" + list.getList().size()+"进入wait");
                synchronized (list){
                    list.wait();
                }
                System.out.println("当前集合长度为：" + list.getList().size()+"出入wait");
                if(list.size() == 5){
                    System.out.println("==5了，线程b要退出了！");
                    throw new InterruptedException();
                }
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ListTest{
    public static void main(String[] args){
        MyList service = new MyList();
        ThreadListA a = new ThreadListA(service);
        a.setName("A");
        a.start();
        ThreadListB b = new ThreadListB(service);
        b.setName("B");
        b.start();
    }
}

class SleepThread extends Thread{

    @Override
    public void run() {
        print();
    }
    synchronized public void print(){
        for(int i = 0 ; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "进来了 " +i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        SleepThread a = new SleepThread();
        SleepThread b = new SleepThread();
        a.setName("A");
        a.start();
        b.setName("B");
        b.start();
    }
}

class Test1{
    public static void main(String[] args){
        try{
            String newString = new String("");
            System.out.println("SYN上面");
            synchronized (newString){
                System.out.println("SYN第一行");
                newString.wait();
                System.out.println("wait下的代码！");
            }
            System.out.println("syn下面的代码");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


class Wait1 extends Thread{
    private Object lock;

    public Wait1(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        try{
            synchronized (lock){
                System.out.println("开始 wait time = " + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束 wait time=" + System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Wait2 extends Thread{
    private Object lock;

    public Wait2(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        try{
            synchronized (lock){
                System.out.println("开始 notify time = " + System.currentTimeMillis());
                lock.notifyAll();
                System.out.println("结束 notify time=" + System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class WaitTest{
    public static void main(String[] args){
        try{
            Object lock = new Object();
            Wait1 t1 = new Wait1(lock);
            t1.start();
            Thread.sleep(3000);
            Wait2 t2 = new Wait2(lock);
            t2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


class WaitService{
    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"begin wait()");
                /*lock.wait();*/
                lock.wait(4000);
                System.out.println(Thread.currentThread().getName()+"end wait()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class ThreadA5 extends  Thread{
    private Object lock;

    public ThreadA5(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        WaitService service = new WaitService();
        service.testMethod(lock);
    }
}
class ThreadB5 extends  Thread{
    private Object lock;

    public ThreadB5(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        WaitService service = new WaitService();
        service.testMethod(lock);
    }
}
class WaitDemo{
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA5 a  = new ThreadA5(lock);
        a.start();

        /*ThreadB5 b = new ThreadB5(lock);
        b.start();*/
        ThreadA5 c  = new ThreadA5(lock);
        c.start();
    }
}