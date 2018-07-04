package cn.wzl.nulidexiaoma.service.impl.thread;/**
 * Created by wenzailong on 2018/5/9.
 */

import java.util.concurrent.Callable;

/**
 * @author wenzailong
 * @create 2018-05-09 11:48
 **/
public class MultiThreadThread implements Callable{
    String name ;

    public MultiThreadThread(String name) {
        this.name = name;
    }
    @Override
    public Object call() throws Exception {
        System.out.println("此时的线程名字叫做"+name);
        double a = Math.random();
        return a;
    }
}
