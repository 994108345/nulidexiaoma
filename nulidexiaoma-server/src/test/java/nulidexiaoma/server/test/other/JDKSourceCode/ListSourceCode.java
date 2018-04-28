package nulidexiaoma.server.test.other.JDKSourceCode;

import org.junit.Test;

import java.util.*;

/**
 * Created by wenzailong on 2018/2/28.
 */
public class ListSourceCode {
    List list = new ArrayList<>();
    List lsit = new LinkedList();
    /*Set;
    SortedSet;
    NavigableSet;
    TreeSet;
    HashSet;
    LinkedHashSet;
    AbstractCollection;*/
    @Test
    public void demo1(){
        int[] r = new int[]{1,2,34,45,23,56,35,46,235634,53,4};
        int a = 0x80000000;
        double b =Math.pow(2,32);
        System.out.println("0x80000000:"+(a));
        System.out.println("0x70000000:"+0x7fffffff);
        System.out.println("0x00000600:"+0x00000600);
        System.out.println("b:"+(int)b);
    }
    @Test
    public void nullTest(){
        String a = null;
        Object o = new Object();
        o = null;
        if(o.hashCode() == 1111){
            System.out.println("a = null");
        }else{
            System.out.println("a != null");
        }
    }
}

interface a {
    int a();
}
interface c extends a{

}
