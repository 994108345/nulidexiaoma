package collection;/**
 * Created by wenzailong on 2018/5/30.
 */

import org.junit.Test;

import java.util.*;

/**
 * @author wenzailong
 * @create 2018-05-30 11:02
 **/
public class CollectionTest {
    public void test1(){
        int[] a = new int[2];
        List list = new ArrayList<>();

    }
    @Test
    public void test2(){
        /*Arrays.asList（）参数是数组或者用逗号隔开的列表*/
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4));
        Integer[] moreInts = {5,6,7,8,9};
        collection.addAll(Arrays.asList(moreInts));
    }
    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);
        Iterator i = list.listIterator();
        while(i.hasNext()){
            System.out.println(i.next());

        }
    }
    @Test
    public void tst4(){
        List list = new LinkedList();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);
        LinkedList linkedList = new LinkedList();
        linkedList.peek();
        linkedList.element();
        linkedList.getFirst();
        Queue queue = new LinkedList();
        queue.offer("1");
    }
    @Test
    public void setTest(){
        Set set = new HashSet();
        set.add("a");
        set.add("b");
        set.add("a");
        System.out.println(set.size());
        for (Object o : set) {
            System.out.print(o+",");
        }
    }
    @Test
    public void linkedListTest(){
        List list = new LinkedList();
        list.add(1);
        list.add(2);
    }
}
