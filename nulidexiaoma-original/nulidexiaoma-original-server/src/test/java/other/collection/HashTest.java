package other.collection;/**
 * Created by wenzailong on 2018/7/23.
 */

import org.junit.Test;

import java.util.*;

/**
 * @author wenzailong
 * @create 2018-07-23 9:58
 **/
public class HashTest {
    private int[] arr = {1,2,3,3};
    @Test
    public void demo1(){
        Map<HashMapTest,String> map = new HashMap<HashMapTest,String>();
        List<HashMapTest> list = new ArrayList<>();
        /*往map中插入数组*/
        for (int i : arr) {
            HashMapTest hashMapTest = new HashMapTest(i);
            map.put(hashMapTest,hashMapTest.toString());
            list.add(hashMapTest);//将key存到集合中，后面要用集合中的key去获取map中的value。
        }
        //for(int i :map)因为map的特殊结构，所以mao没有迭代也没用循环遍历
        System.out.println("map的长度:"+map.size());
        for (HashMapTest hashMapTest : list) {
            System.out.println("map的key：" + hashMapTest.toString());
            String string = map.get(hashMapTest);
            System.out.println("map的value:"+string);
        }

        HashMapTest hashMapTest = new HashMapTest(3);
        String resultStr = map.get(hashMapTest);
        System.out.println("根据key取值：" + resultStr);
    }
}


