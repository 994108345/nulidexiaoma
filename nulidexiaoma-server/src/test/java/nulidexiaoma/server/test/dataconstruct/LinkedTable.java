package nulidexiaoma.server.test.dataconstruct;

import org.junit.Test;


/**
 * 链表
 */
public class LinkedTable{
    private Node[] linked = new Node[100];
    Node node;
    int firstIndex = 0;

    public LinkedTable() {
        linked[1] = new Node("1",1);
        linked[2] = new Node("2",2);
        linked[3] = new Node("3",3);
        linked[4] = new Node("4",4);
        linked[5] = new Node("5",5);
        linked[6] = new Node("6",6);
        linked[7] = new Node("7",7);
        linked[8] = new Node("8",8);
        linked[9] = new Node("9",9);
        linked[10] = new Node("10",0);
    }
    /**获取限制的内存空间*/
    int backNullIndex() throws Exception {
        for (int i = 0; i < linked.length; i++) {
            Node node = linked[i];
            if(null == node){
                return i;
            }
        }
        throw new Exception("内存中没有多余的位置");
    }


    /**插入新结点*/
    void insertNode(Node node,int index) throws Exception {
        Node frontNode = linked[index];//获取要插入的位置的结点
        int frontIndex = frontNode.index;//后一个结点的地址
        node.index= frontIndex;//将插入的结点与后一个结点关联
        int freeIndex = backNullIndex();//获取闲置内存空间地址
        frontNode.index = freeIndex;//给前一个结点与插入结点关联
        linked[freeIndex] = node;
        printLinked(linked);
    }

    /**删除结点*/
    void deleteNode(int index){
        Node frontNode = linked[index];//前结点
        Node deleteNode = linked[index+1];//删除节点
        int behindIndex = deleteNode.index;
        deleteNode = null;
        frontNode.index = behindIndex;
        printLinked(linked);
    }

    /**打印链表*/
    void printLinked(Node[] nodes){
        int index = firstIndex;
        while(true){
            Node node = nodes[index];
            index = node.index;
            if(index == 0){
                System.out.print(node.data.toString());
                break;
            }
            System.out.print(node.data.toString());
        }
    }

    /**结点对象*/
    class Node{
        int index ;//下一个结点地址,0就是没有结点的意思！
        String data;//保存的数据

        public Node(String data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    @Test
    public void insertDemo() throws Exception {
        Node node = new Node("插入的",0);
        insertNode(node,0);
    }
    @Test
    public void deleteDemo(){
        deleteNode(3);
    }
}
