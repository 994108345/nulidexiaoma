package nulidexiaoma.server.test.other.dataconstruct;

/**
 * Created by wenzailong on 2018/2/7.
 */
public class TwoTrees {








    class Node{
        int leftChild;
        int rightChild;
        int index;
        int parent;
        Object data;

        public Node(int leftChild, int rightChild, int index, int parent, Object data) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.index = index;
            this.parent = parent;
            this.data = data;
        }
    }
}
