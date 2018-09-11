package other.generic;/**
 * Created by wenzailong on 2018/6/4.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author wenzailong
 * @create 2018-06-04 14:39
 **/
public class Sets {
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;

    }
    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }
    public static <T> Set<T> difference(Set<T> superSet,Set<T> subSet){
        Set<T> result = new HashSet<T>(superSet);
        result.removeAll(subSet);
        return result;
    }
    public static <T> Set<T> complement(Set<T> a,Set<T> b){
        return difference(union(a,b),intersection(a,b));
    }
}
