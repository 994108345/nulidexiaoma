package nulidexiaoma.server.test.other.Thread_book;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzailong on 2018/1/31.
 */
public class WaitNotify {
}
class ValueObject {
    public static String value = "";
}
/*生产者*/
class P {
    private String lock;
    public P (String lock){
        this.lock = lock;
    }
   public void setValue(){
       try {
           synchronized (lock) {
               if (!ValueObject.value.equals("")){
                   lock.wait();
               }
               String  value = System.currentTimeMillis() +  "_" + System.nanoTime();
               System.out.println("set是值是" + value);
               ValueObject.value = value;
               lock.notify();
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}
/*消费者*/
class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }
    public  void getValue(){
        try {
            synchronized (lock){
                if (ValueObject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get的值是" + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class ThreadP extends Thread{
    private P  p;

    public ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        int i = 0;
        while(i<5){
            p.setValue();
            i++;
        }
    }
}

class ThreadC extends Thread{
    private C  c;

    public ThreadC(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        int i = 0;
        while(i < 5){
            c.getValue();
            i++;
        }
    }
}
class RunPC {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C r = new C(lock);
        ThreadP threadp = new ThreadP(p);
        ThreadC threadC = new ThreadC(r);
        threadp.start();
        threadC.start();
    }
}

class MyStack {
    private List list = new ArrayList<>();
    synchronized public void push(){
        try {
            if(list.size() ==1){
                this.wait();
            }
            list.add("anyString =" + Math.random());
            this.notify();
            System.out.println("push=" +list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    synchronized public String pop(){
        String returnValue = "";
        try {
            if(list.size() == 0){
                System.out.println("pop操作中的:"
                +Thread.currentThread().getName() + "线程呈wait状态");
                this.wait();
            }
            returnValue = "" + list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("pop = " + list.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
class Thread_P extends Thread{
    private P_P  p;

    public Thread_P(P_P p) {
        this.p = p;
    }

    @Override
    public void run() {
        int i = 0;
        while(i<5){
            p.pushService();
            i++;
        }
    }
}

class Thread_C extends Thread{
    private C_C  c;

    public Thread_C(C_C c) {
        this.c = c;
    }

    @Override
    public void run() {
        int i = 0;
        while(i < 5){
            c.popService();
            i++;
        }
    }
}
class P_P {
    private MyStack myStack;

    public P_P(MyStack myStack) {
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }
}
class C_C {
    private MyStack myStack;

    public C_C(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop=" + myStack.pop());
    }
}
class RunP_C{
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P_P p = new P_P(myStack);
        C_C r =new C_C(myStack);
        Thread_P thread_p = new Thread_P(p);
        Thread_C thread_c = new Thread_C(r);
        thread_p.start();
        thread_c.start();
    }
}