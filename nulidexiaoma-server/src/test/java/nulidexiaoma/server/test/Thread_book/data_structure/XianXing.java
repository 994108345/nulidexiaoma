package nulidexiaoma.server.test.Thread_book.data_structure;


import com.graphbuilder.struc.LinkedList;
import org.junit.Test;

import java.util.Stack;


/**
 * Created by 99410 on 2018/2/4.
 */
public class XianXing {
    int[] xianXingTable = new int[10];
    int size;
    LinkedList.Node node;
    LinkedList list = new LinkedList();
    @Test
    public void Demo1(){
        xianXingTable[0] = 0;
        xianXingTable[1] = 1;
        xianXingTable[2] = 2;
        xianXingTable[3] = 3;
        xianXingTable[4] = 4;
        xianXingTable[5] = 5;
        System.out.println(xianXingTable.length);


    }
    @Test
    public void Demo2(){
        list.addToHead("1");
        list.addToHead("2");
        list.addToHead("3");
        list.addToHead("4");
        list.addToHead("5");
        list.addToHead("6");
        list.addToHead("7");
        System.out.println(list.size());
        System.out.println(list.getHead());
        System.out.println(list.getTail());
        node = list.getHead();
        System.out.println(node.getUserObject().toString());
        System.out.println(node.next().getUserObject().toString());
    }

    @Test
    public  void Demo3(){
        Stack stack = new Stack();
        node.list();

        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.size());


    }

}

