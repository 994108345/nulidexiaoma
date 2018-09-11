package other.generic;/**
 * Created by wenzailong on 2018/6/4.
 */

import java.util.ArrayList;

/**
 * @author wenzailong
 * @create 2018-06-04 15:16
 **/
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
