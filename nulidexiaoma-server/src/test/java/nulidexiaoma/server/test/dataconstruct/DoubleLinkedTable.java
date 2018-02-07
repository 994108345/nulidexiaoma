package nulidexiaoma.server.test.dataconstruct;

import org.junit.Test;

/**
 * 双向链表
 */
public class DoubleLinkedTable {
    Node[] nodes = new Node[100];
    int firstIndex = 1;
    int endIndex;


    public DoubleLinkedTable() {
        nodes[1] = new Node(0,2,"1");
        nodes[2] = new Node(1,3,"2");
        nodes[3] = new Node(2,4,"3");
        nodes[4] = new Node(3,5,"4");
        nodes[5] = new Node(4,0,"5");
        endIndex = finadEndIndex(nodes);
    }

    /**插入新结点*/
    void insertNode(Node nd,int index) throws Exception {
        Node frontNode = nodes[index];//获取要插入的位置的结点
        int behindIndex = frontNode.behind;//后一个结点的地址

        Node behindNode = nodes[behindIndex];//插入位置后的结点
        int  frontIndex = behindNode.front;//前一个结点的地址

        nd.front = frontIndex;
        nd.behind = behindIndex;

        int insertIndex = backNullIndex();
        nodes[insertIndex] = nd;

        frontNode.behind = insertIndex;
        behindNode.front = insertIndex;


        printDoubleLinked(nodes);
    }
    @Test
    public void insertDemo() throws Exception {
        Node node = new Node(0,0,"插入的");
        insertNode(node,2);
    }
    /**删除新结点:如果删除的是首末节点就需要慎重了*/
    void deleteLinked(int deleteIndex){
        Node deleteNode = nodes[deleteIndex];
        if(deleteIndex == firstIndex){

            int behindIndex = deleteNode.behind;
            Node behindNode = nodes[behindIndex];
            behindNode.front = 0;
            this.firstIndex = behindIndex;//删除了首结点，所以修改了首届点地址
        }else if(deleteIndex == endIndex){
            int frontIndex = deleteNode.front;
            Node frontNode = nodes[frontIndex];
            frontNode.behind = 0;
            this.endIndex = frontIndex;//删除了尾结点，所以修改了尾届点地址
        }else {
            int frontIndex = deleteNode.front;
            int behindIndex = deleteNode.behind;

            Node frontNode = nodes[frontIndex];
            Node behindNode = nodes[behindIndex];

            frontNode.behind = behindIndex;
            behindNode.front = frontIndex;
        }
        nodes[deleteIndex] = null;
        printDoubleLinked(nodes);
    }
    @Test
    public void delete() {
        deleteLinked(2);
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
    /**找到最后一个节点的地址*/
    int finadEndIndex(Node[] nodes){
        int behind = firstIndex;
        while(true){
            int endIndex = behind;
            Node node = nodes[behind];
            behind = node.behind;
            if(behind == 0){
                return endIndex;
            }
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
    /**获取限制的内存空间*/
    int backNullIndex() throws Exception {
        for (int i = 1; i < nodes.length; i++) {
            Node node = nodes[i];
            if(null == node){
                return i;
            }
        }
        throw new Exception("内存中没有多余的位置");
    }
}
