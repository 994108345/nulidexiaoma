package nulidexiaoma.server.test.thinking_in_java.multithreading;

import sun.java2d.pipe.SpanShapeRenderer;

import java.util.concurrent.TimeUnit;

/**
 * Created by wenzailong on 2018/1/26.
 */
public class SimpleThread extends Thread{
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() throws InterruptedException {
        super(Integer.toString(++threadCount));
        start();
    }
    public String toString(){
        return "#" + getName() + "(" + countDown + ").";
    }
    public void run (){
        while(true){
            System.out.println(this);
            if(--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i =0; i< 5; i++){
            new SimpleThread();
        }
    }
}
