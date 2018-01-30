package nulidexiaoma.server.test.Thread_book;

import org.junit.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wenzailong on 2018/1/29.
 */
public class StringTEST {
}
class StringService{
    /*string常量锁*/
    public static void print(String stringParam){
        try{
            synchronized (stringParam){
                while(true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 对象锁
     * @param object
     */
    public static void printObject(Object object){
        try{
            synchronized (object){
                while(true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class StringThreadA extends Thread{
    private StringService stringService;
    public StringThreadA(StringService stringService){
        this.stringService = stringService;
    }

    @Override
    public void run() {
        /*stringService.print("AA");*/
        stringService.printObject(new Object());
    }
}
class StringThreadB extends Thread{
    private StringService stringService;
    public StringThreadB(StringService stringService){
        this.stringService = stringService;
    }

    @Override
    public void run() {
        /*stringService.print("AA");*/
        stringService.printObject(new Object());
    }
}
class StringRun{
    public static void main(String[] args){
        StringService stringService = new StringService();
        StringThreadA a = new StringThreadA(stringService);
        a.setName("A");
        a.start();
        StringThreadB b = new StringThreadB(stringService);
        b.setName("B");
        b.start();
    }
}
class DealThread implements Runnable{
    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();
    public void setFlag(String username){
        this.username = username;
    }
    @Override
    public void run() {
     if(this.username .equals("a")){
         synchronized (lock1){
             try{
                 System.out.println("username = " + username);
                 Thread.sleep(3000);
             }catch(Exception e){
                 e.printStackTrace();
             }
             synchronized (lock2){
                 System.out.println("按lock1 -> lock2 代码顺序执行了");
             }
         }
     }
     if(username.equals("b")){
         synchronized (lock2){
             try{
                 System.out.println("username = " + username);
                 Thread.sleep(3000);
             }catch (Exception e){
                 e.printStackTrace();
             }
             synchronized (lock1){
                 System.out.println("按lock2 -> lock1 代码顺序执行了");
             }
         }
     }
    }
}
class Run10{
    public static void main(String[] args){
        try{
            DealThread t1 = new DealThread();
            t1.setFlag("a");
            Thread thread1 = new Thread(t1);
            thread1.start();
            Thread.sleep(100);
            t1.setFlag("b");
            Thread thread2 = new Thread(t1);
            thread2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class PublicClass{
    private String username;
    private String password;
    class PrivateClass{
        private String age;
        private String address;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
        public void printPublicProperty(){
            System.out.println(username+"" +password);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class RunPublic {
    public static void main(String[] args){
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");
        System.out.println(publicClass.getUsername() + " " + publicClass.getPassword());
        PublicClass.PrivateClass privateClass = publicClass.new PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
    }

}

class OutClass{
    static class InnerClass1{
        public void method1(InnerClass2 class2){
            String threadName = Thread.currentThread().getName();
            synchronized (class2){
                System.out.println(threadName + "进入InnerClass1类中的method1方法");
                for(int i = 0; i < 10; i++){
                    System.out.println("i = " + i);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName + "离开InnerClass1类中的method1方法");
            }
        }
        public synchronized void method2(){
            String  threadName = Thread.currentThread().getName();
            System.out.println(threadName + "进入InnerClass1类中的method2方法");
            for(int j = 0; j < 10; j++){
                System.out.println("j = " + j);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + "离开InnerClass1类中的method2方法");
        }
    }
    static class InnerClass2{
        public synchronized void method1(){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "进入InnerClass1类中的method1方法");
                for(int k = 0; k < 10; k++){
                    System.out.println("k = " + k);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName + "离开InnerClass2类中的method1方法");
        }
    }
}
class Run11{
    public static void main(String[] args){
        final OutClass.InnerClass1 in1 = new OutClass.InnerClass1();
        final OutClass.InnerClass2 in2 = new OutClass.InnerClass2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                in1.method1(in2);
            }
        },"T1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                in1.method2();
            }
        },"T2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                in2.method1();
            }
        },"T3");
        t1.start();
        t2.start();
        t3.start();
    }
}



class MyService{
    private String  lock = "123";
    public void testMethod(){
        try{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"begin");
                Thread.sleep(1000);
                lock = "456";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"end");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class ThreadA6 extends Thread{
 private MyService myService;
 public ThreadA6(MyService myService){
     super();
     this.myService = myService;
 }

    @Override
    public void run() {
        myService.testMethod();
    }
}
class ThreadB6 extends Thread{
    private MyService myService;
    public ThreadB6(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}

class Run12{
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA6 a = new ThreadA6(myService);
        a.setName("A");
        ThreadB6 b = new ThreadB6(myService);
        b.setName("B");
        a.start();
        b.start();
    }

}

class AddCount extends Thread{
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for(int i = 0; i<10000;i++){
            System.out.println(Thread.currentThread().getName()+":"+count.incrementAndGet());
        }
    }
    public static void main(String[] args){
        for(int i = 0; i<10;i++){
            AddCount addCount = new AddCount();
            addCount.setName(Integer.toString(i));
            addCount.start();
        }
    }
}

class MyService1{
    public static AtomicLong aiRef = new AtomicLong();
    public void addNum(){
        System.out.println(Thread.currentThread().getName()+"加了100之后的值是：" + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }

}

class MyThread12 extends Thread{
    private MyService1 myService1 = new MyService1();
    public MyThread12(MyService1 myService1){
        this.myService1 = myService1;
    }

    @Override
    public void run() {
        myService1.addNum();
    }
    public static void main(String[] args){
        try{

            MyService1 myService1s = new MyService1();
            MyThread12[] myThread12s = new MyThread12[20];
            for(int i = 0; i< myThread12s.length;i++){
                myThread12s[i] = new MyThread12(myService1s);
            }
            for(int i = 0; i<myThread12s.length; i++){
                myThread12s[i].start();
            }
            Thread.sleep(1000);
            System.out.println(myService1s.aiRef.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


class A{

}

class ServiceR{
    private boolean isContinueRun = true;
    int i = 0;
    public  void runMethod() throws InterruptedException {
        String anyThing = new String();
        System.out.println(ThraedB.currentThread().getName()+":"+isContinueRun);
        while(i < 5 ){
            System.out.println(i);
        }
        System.out.println(ThraedB.currentThread().getName()+":"+isContinueRun);
        System.out.println("停下来了！");
    }
    public void stopMethod(){
        isContinueRun = false;
        i++;
    }
}

class ThreadA extends Thread{
    private ServiceR service;
    public  ThreadA(ServiceR service){
        this.service = service;
    }

    @Override
    public void run() {
        try {
            service.runMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThraedB extends Thread{
    private ServiceR service;
    public ThraedB(ServiceR service) {
        this.service = service;
    }
    @Override
    public void run() {
        for (int i = 0; i < 8 ; i++) {
            service.stopMethod();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunR{
    public static void main(String[] args){
        try{
            ServiceR service = new ServiceR();
            ThreadA a =new ThreadA(service);
            a.setName("A");
            a.start();
            ThraedB b = new ThraedB(service);
            b.setName("B");
            b.start();
            a.interrupt();
            System.out.println("已经发起停止命令！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
