package other.collection;/**
 * Created by wenzailong on 2018/7/23.
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenzailong
 * @create 2018-07-23 10:31
 **/
public class HashMapTest {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public HashMapTest(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "HashMapTest{" +
                "num='" + num + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return num;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HashMapTest && num==((HashMapTest) obj).num){
           return true;
        }
        return false;
    }
}
