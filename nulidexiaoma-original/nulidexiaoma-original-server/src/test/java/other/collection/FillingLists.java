package other.collection;/**
 * Created by wenzailong on 2018/5/30.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wenzailong
 * @create 2018-05-30 16:29
 **/
public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4,new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list,new StringAddress(":World"));
        System.out.println(list);
    }
}
