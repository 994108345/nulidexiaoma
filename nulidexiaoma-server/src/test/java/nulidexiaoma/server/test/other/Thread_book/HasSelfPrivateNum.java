package nulidexiaoma.server.test.other.Thread_book;

/**
 * Created by wenzailong on 2018/1/29.
 */
public class HasSelfPrivateNum {
    /***方法外是非线程安全*/
    private int num = 0;
    synchronized public void addI(String username){
        try{
             /**方法内部的变量是线程安全的*/
        /*int num = 0 ;*/
        if(username.equals("a")){
            num = 100;
            System.out.println("a set over!");
            Thread.sleep(2000);
        }else{
            num = 200;
            System.out.println("b set over!");
        }
        System.out.println(username + " num =" + num);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

class ThreadA11 extends Thread{
    private HasSelfPrivateNum numRef;
    public ThreadA11(HasSelfPrivateNum numRef){
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
class ThreadB extends Thread{
    private HasSelfPrivateNum numRef;
    public ThreadB(HasSelfPrivateNum numRef){
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
class Run4{
    public static void main(String[] args){
        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
        ThreadA11 athread = new ThreadA11(numRef1);
        athread.start();
        ThreadB bthread = new ThreadB(numRef2);
        bthread.start();
    }
}



class MyObject1{
    public void methodA(){
        try{
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
class ThreadA1 extends Thread{
    private MyObject1 myObject1;
    public ThreadA1(MyObject1 myObject1){
        super();
        this.myObject1 = myObject1;
    }

    @Override
    public void run() {
        super.run();
        myObject1.methodA();
    }
}
class ThreadB1 extends Thread{
    private MyObject1 myObject1;
    public ThreadB1(MyObject1 myObject1){
        super();
        this.myObject1 = myObject1;
    }

    @Override
    public void run() {
        super.run();
        myObject1.methodA();
    }
}
class Run5{
    public static void main(String[] args){
        MyObject1 Object = new MyObject1();
        ThreadA1 a = new ThreadA1(Object);
        a.setName("A");
        ThreadB1 b = new ThreadB1(Object);
        b.setName("B");
        a.start();;
        b.start();
    }
}

class  Service{
    synchronized public void service1(){
        System.out.println("service1");
        service2();
    }
    synchronized  public void service2(){
        System.out.println("service2");
        service3();
    }
    synchronized  public void service3(){
        System.out.println("service3");
    }
}

class MyThread extends  Thread{
    @Override
    public void run() {
        super.run();
        Service service = new Service();
        service.service1();
    }
}

class Run6{
    public static void main(String[] args){
        MyThread t = new MyThread();
        t.start();
    }
}

class Main{
    public int i = 10;
    synchronized  public void operateIMainMethod(){
        try{
            i--;
            System.out.println("main print i =" + i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Sub extends Main{
    synchronized  public void operateISubMethod(){
        try{
            while(i>0){
                i --;
                System.out.println("sub print i = " + 1);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class MyThread1 extends  Thread{

    @Override
    public void run() {
        super.run();
        Sub sub = new Sub();
        sub.operateISubMethod();;
    }
}
class Run{
    public static void main(String[] args){
        MyThread1 t =  new MyThread1();
        t.start();
    }
}

class Main1{
    synchronized  public void serviceMethod(){
        try{
            System.out.println("int main 下一步 sleep begin threadName="
                    + Thread.currentThread().getName()+" time ="
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int main 下一步 sleep end threadName ="
            +Thread.currentThread().getName()+" time="
            +System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Sub1 extends  Main1{
    @Override
    public void serviceMethod() {
        try{
            System.out.println("int sub 下一步 sleep begin threadName="
                    + Thread.currentThread().getName()+" time ="
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int sub 下一步 sleep end threadName ="
                    +Thread.currentThread().getName()+" time="
                    +System.currentTimeMillis());
            super.serviceMethod();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class MyThreadA extends  Thread{
    private Sub1 sub;
    public MyThreadA(Sub1 sub){
        super();
        this.sub =sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
class MyThreadB extends  Thread{
    private Sub1 sub;
    public MyThreadB(Sub1 sub){
        super();
        this.sub =sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
class Test{
    public static void main(String[] args){
        Sub1 subRef = new Sub1();
        MyThreadA a = new MyThreadA(subRef);
        a.setName("A");
        a.start();
        MyThreadB b = new MyThreadB(subRef);
        b.setName("B");
        b.start();
    }
}

