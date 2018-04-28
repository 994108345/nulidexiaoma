package nulidexiaoma.server.test.other.multithreading;

/**
 * Created by wenzailong on 2018/1/28.
 */
public class SleepToStop {
}

class MyThreads extends Thread{
    @Override
    public void run() {
        try{
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        }catch (Exception e){
            System.out.println("在沉睡中被停止！进入catch！"+this.isInterrupted()+this.interrupted());
            e.printStackTrace();
        }
    }
}
class Runs{
    public static void main(String[] srgs){
        try{
            MyThreads thread = new MyThreads();
            thread.start();

            thread.interrupt();
            System.out.println(thread.interrupted());
            System.out.println(thread.isInterrupted()+""+thread.interrupted());
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("man catch");
        }
        System.out.println("end!");
    }
}
