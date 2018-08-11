package generic;/**
 * Created by wenzailong on 2018/6/4.
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author wenzailong
 * @create 2018-06-04 16:08
 **/
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }
    T[] create(int size){
        return (T[]) Array.newInstance(kind,size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));

        ArrayMaker<String> stringMaker1 = new ArrayMaker<String>(String.class);
        System.out.println(stringMaker1.kind.getName());
    }
}


