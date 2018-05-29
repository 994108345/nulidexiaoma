package datastructure;/**
 * Created by wenzailong on 2018/5/29.
 */

/**
 * @author wenzailong
 * @create 2018-05-29 15:41
 **/
public class SingleLink {
    Node[] nodes = new Node[20];

    public SingleLink() {
        Node headNode = new Node();
        headNode.address = 1;
        headNode.value = "5";
        Node node1 = new Node();
        node1.address = 2;
        node1.value = "1";
        Node node2 = new Node();
        node2.address = 3;
        node2.value = "2";
        Node node3 = new Node();
        node3.address = 4;
        node3.value = "3";
        Node node4 = new Node();
        node4.address = 5;
        node4.value = "4";
        nodes[0] = headNode;
        nodes[1] = node1;
        nodes[2] = node2;
        nodes[3] = node3;
        nodes[4] = node4;

    }

    public void  addValue(int value,int index){
        Node headNode = nodes[0];
        if(headNode.address == null){
            System.out.println("该链表为空");
            return;
        }
        for (int i = 1; i < nodes.length; i++) {

        }
    }
    class Node{
        Integer address;
        String value;
    }
}

