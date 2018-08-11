package jvm;/**
 * Created by wenzailong on 2018/6/25.
 */

import org.junit.Test;

/**
 * @author wenzailong
 * @create 2018-06-25 10:47
 **/
public class StaticDispatch {
    static abstract class Human{}
    static class Man extends Human{}
    static class Women extends Human{}
    public void sayHello(Human guy){
        System.out.println("hello guy!");
    }

    public void sayHello(Man guy){
        System.out.println("hello gentlemen!");
    }
    public void sayHello(Women guy){
        System.out.println("hello lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human women = new Women();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(women);
    }
}
