package other.jvm;/**
 * Created by wenzailong on 2018/6/7.
 */

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wenzailong
 * @create 2018-06-07 16:24
 **/
public class OutOfMemoryErrorTest {
    List resultList = new ArrayList<>();
    /*java堆溢出*/
    @Test
    public void heapException(){
        int i = 1;
        while(true){
            byte[] b = new byte[1024*1024*100];
            resultList.add(b);
            System.out.println(String.format("打印了%s",i));
            i++;
        }
    }
    /*单线程java栈内存溢出*/
    @Test
    public  void jVMStackErrorTest() throws InterruptedException {
        Thread thread = new Thread(new JVMStackError());
        thread.start();
        thread.join();
    }
    class JVMStackError implements Runnable{
        int i = 1;
        void foreachThread(){
            System.out.println(String.format("第%s个线程",i));
            i++;
            foreachThread();
        }
        @Override
        public void run() {
            foreachThread();
        }
    }
    /*多线程java栈深度溢出*/
    @Test
    public  void createThreadErrorTest() throws InterruptedException {
        int i = 1;
        while(true){
            Thread thread = new Thread(new CreateThreadError(i));
            thread.start();
            i++;
        }
    }
    class CreateThreadError implements Runnable{
        int i ;
        public CreateThreadError(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            System.out.println(String.format("第%s个线程",i));
        }
    }
    /*常量池溢出*/
    @Test
    public void constantPoolError(){
        List resultList = new ArrayList<>();
        long l = 1;
        StringBuilder sbf = new StringBuilder("1");
        while(true){
            resultList.add(sbf);
            /*循环一次是10M大小*/
            for (int i = 0; i < 1024*1024*100; i++) {
                sbf.append("1");
            }
            String.valueOf(sbf).intern();
            System.out.println(l++ + sbf.toString());
        }
    }
    /*方法区溢出*/
    @Test
    public void mathodAreaErrorTest(){
        int i = 1;
        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            enhancer.create();
            System.out.println(i);
            i++;
        }
    }
    static  class OOMObject{}
}
