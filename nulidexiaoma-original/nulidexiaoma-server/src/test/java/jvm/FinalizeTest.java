package jvm;/**
 * Created by wenzailong on 2018/6/11.
 */

import org.junit.Test;

/**
 * @author wenzailong
 * @create 2018-06-11 11:21
 **/
public class FinalizeTest {
    public static FinalizeTest SAVE_HOOK = null;
    public void isAlive(){
        System.out.println("我还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize方法被执行");
        //给SAVE_HOOK赋予了新的引用，所以不用背gc回收了
        FinalizeTest.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeTest();
        //等于null就是告诉gc可以回收这个对象了
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);//给一点时间让gc执行
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("我已经死了");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);//给一点时间让gc执行
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("我已经死了");
        }
    }

    @Test
    public void theradTest(){
        System.out.println("begin");
        for (int i = 0; i < 10; i++) {
            byte[] b = new byte[1024 * 1024 * 100];
        }
        System.out.println("end");
    }
}
