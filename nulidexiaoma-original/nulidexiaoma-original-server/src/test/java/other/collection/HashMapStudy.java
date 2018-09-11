package other.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 99410 on 2018/9/6.
 */
public class HashMapStudy {
    @Test
    public void hashMapTest(){
        Map map = new HashMap();
        map.put('1',"a");
        map.get('1');
        String[] strr ={null,null};
        Object object = new Object();
        Object o2 = new Object();
        System.out.println(object.hashCode()+";"+object.toString());
        System.out.println(o2.hashCode());
    }


    @Test
    public void  floatNoNTest(){
        Float f1 = new Float(1.0/0.0);
        Float f2 = new Float(0.0/0.0);
        Float f3 = new Float(Math.sqrt(-100));
        Double d1 = new Double(1.0/0.0);
        Double d2 = new Double(0.0/0.0);
        System.out.println(f1 +":" + f1.isNaN());
        System.out.println(f2 + ":" + f2.isNaN());
        System.out.println(f3 +":" + f3.isNaN());
        System.out.println(d1 +":" + d1.isNaN());
        System.out.println(d2 + ":" + d2.isNaN());

    }
    @Test
    public void demo1Test(){
        int a = 8;
        int b = ~a;
        System.out.println(b);
    }
}
