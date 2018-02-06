package nulidexiaoma.server.test.dataconstruct;

import org.junit.Test;

/**
 * 双向链表
 */
public class DoubleLinkedTable {
    Node[] nodes = new Node[100];
    int firstIndex = 1;


    public DoubleLinkedTable() {
        nodes[1] = new Node(0,2,"1");
        nodes[2] = new Node(1,3,"2");
        nodes[3] = new Node(2,4,"3");
        nodes[4] = new Node(3,5,"4");
        nodes[5] = new Node(4,0,"5");
    }

    /**插入新结点*/
    void insertNode(Node nd,int index) throws Exception {
        Node frontNode = nodes[index];//获取要插入的位置的结点
        int behindIndex = frontNode.behind;//后一个结点的地址

        Node behindNode = nodes[behindIndex];//插入位置后的结点
        int  frontIndex = behindNode.front;

        frontNode.front = behindIndex;
        frontNode.behind = frontIndex;

        printDoubleLinked(nodes);
    }

    @Test
    public void insertDemo() throws Exception {
        Node node = new Node(0,0,"插入的");
        insertNode(node,2);
    }

    /**打印链表*/
    void printDoubleLinked(Node[] nodes){
        int behind = firstIndex;
        while(true){
            Node node = nodes[behind];
            behind = node.behind;
            if(behind == 0){
                System.out.print(node.data.toString());
                break;
            }
            System.out.print(node.data.toString());
        }
    }

    class Node {
        int front;
        int behind;
        String data;

        public Node(int front, int behind, String data) {
            this.front = front;
            this.behind = behind;
            this.data = data;
        }
    }
}
