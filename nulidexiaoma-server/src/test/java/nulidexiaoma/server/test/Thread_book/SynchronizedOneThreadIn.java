package nulidexiaoma.server.test.Thread_book;

/**
 * Created by wenzailong on 2018/1/29.
 */
public class SynchronizedOneThreadIn {
}
class ObjectService{
    public void serviceMethod(){
        try{
            synchronized (this){
                System.out.println("begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end end=" + System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class ThreadA2 extends Thread{
    private ObjectService service;
    public ThreadA2(ObjectService service){
        this.service = service;
    }
    @Override
    public void run() {
        super.run();
        service.serviceMethod();

    }
}
class ThreadB2 extends Thread{
    private ObjectService service;
    public ThreadB2(ObjectService service){
        this.service = service;
    }
    @Override
    public void run() {
        super.run();
        service.serviceMethod();

    }
}
class Run7{
    public static void main(String[] args){
    ObjectService service = new ObjectService();
    ThreadA2 a = new ThreadA2(service);
    ThreadB2 b = new ThreadB2(service);
    a.setName("A");
    b.setName("B");
    a.start();
    b.start();

    }
}

class Service1 {
    private String usernameParam;
    private String passwordParam;

    public void setUsernamePassword(String username, String password) {
        try {
            String anyString = new String();
            synchronized (anyString) {
                System.out.println("线程名称为：" + Thread.currentThread().getName()
                        + "在" + System.currentTimeMillis() + " 进入同步块");
                usernameParam = username;
                Thread.sleep(3000);
                passwordParam = password;
                System.out.println("线程名称为：" + Thread.currentThread().getName()
                        + "在" + System.currentTimeMillis() + " 离开同步块");
            }
        }catch(Exception e){
                e.printStackTrace();
        }
    }
}
class ThreadA3 extends Thread{
    private Service1 service;
    public ThreadA3(Service1 service){
        this.service = service;
    }
    @Override
    public void run() {
        super.run();
        service.setUsernamePassword("a","aa");
    }
}
class ThreadB3 extends Thread{
    private Service1 service;
    public ThreadB3(Service1 service){
        this.service = service;
    }
    @Override
    public void run() {
        super.run();
        service.setUsernamePassword("b","bb");
    }
}
class Run8{
    public static void main(String[] args){
        Service1 service1 = new Service1();
        ThreadA3 a = new ThreadA3(service1);
        a.setName("A");
        a.start();
        ThreadB3 b = new ThreadB3(service1);
        b.setName("B");
        b.start();
    }
}

class Service2 {
    synchronized public static void printA(){
        try{
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + " 进入printA");
            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + " 离开printA");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    synchronized public static void printB(){
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + " 进入printB");
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + " 离开printB");
    }
}
class ThreadA4 extends Thread{
    private Service2 service;
    @Override
    public void run() {
        super.run();
        service.printA();
    }
}
class ThreadB4 extends Thread{
    private Service2 service;
    @Override
    public void run() {
        super.run();
        service.printB();
    }
}
class Run9{
    public static void main(String[] args){
        ThreadA4 a = new ThreadA4();
        a.setName("A");
        a.start();
        ThreadB4 b = new ThreadB4();
        b.setName("B");
        b.start();
    }
}