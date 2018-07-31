package generic;/**
 * Created by wenzailong on 2018/6/4.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenzailong
 * @create 2018-06-04 10:33
 **/
public class GenericVarargs {
    public static <T> List<T> makeList(T... args){
        List<T> result = new ArrayList<T>();
        for (T arg : args) {
            result.add(arg);
        }
        return result;
    }
    public static <T> List<T> arrayList(T[] args){
        List<T> result = new ArrayList<T>();
        for (T arg : args) {
            result.add(arg);
        }
        return result;
    }
    public static void main(String[] args){
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A","B","C");
        System.out.println(ls);
        ls = arrayList("ABCSEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
