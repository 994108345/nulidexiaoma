package other.generic;/**
 * Created by wenzailong on 2018/6/4.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenzailong
 * @create 2018-06-04 16:28
 **/
public class FilledListMaker<T> {
    List<T> create(T t,int n){
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < n ; i++) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringMaker = new FilledListMaker<String>();
        List<String> list = stringMaker.create("hello",4);
        System.out.println(list);
    }
}

