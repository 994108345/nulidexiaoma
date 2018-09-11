package other.jvm;/**
 * Created by wenzailong on 2018/7/5.
 */

import org.junit.Test;

/**
 * @author wenzailong
 * @create 2018-07-05 10:31
 **/
public class Demo1 {
    @Test
    public void demo1(){
        Integer wzl = new Integer(12999);
        Integer bo = new Integer(12999);
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 10000000L;
        Long i = 10000000L;
        Long j = 3L;
        System.out.println(wzl.equals(bo));//true
        System.out.println(c == d);//true
        System.out.println(e == f);//false
        System.out.println(c == (a + b));//true
        System.out.println(c.equals(a + b));//true
        System.out.println( g ==(a + b));//true
        System.out.println(g.equals( a + b));//false
        System.out.println(h == i);//false
        System.out.println(g == j);//true
    }
}
