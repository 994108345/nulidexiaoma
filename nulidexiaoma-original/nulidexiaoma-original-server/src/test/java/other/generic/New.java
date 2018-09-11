package other.generic;/**
 * Created by wenzailong on 2018/6/4.
 */


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wenzailong
 * @create 2018-06-04 9:51
 **/
public class New {
    public static <K,V> Map<K,V> map(){
        return new HashMap<K,V>();
    }
    static void f(Map<Map,List< ? extends List>> map){}

    public static void main(String[] args) {
//        New.f(New.map());
    }
}

