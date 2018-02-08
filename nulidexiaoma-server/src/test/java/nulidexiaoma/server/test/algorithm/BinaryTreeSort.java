package nulidexiaoma.server.test.algorithm;

import org.junit.Test;

/**
 * 二叉排序树
 */
public class BinaryTreeSort {
    private Binary binary;

    public BinaryTreeSort() {
        Binary binary4 = new Binary(null,null,8);
        Binary binary5 = new Binary(null,null,12);
        Binary binary6 = new Binary(null,null,18);
        Binary binary7 = new Binary(null,null,25);
        Binary binary1 = new Binary(binary4,binary5,10);
        Binary binary2 = new Binary(binary6,binary7,20);
        binary = new Binary(binary1,binary2,15);//根节点

    }
    /**查找二叉排序树*/
    boolean searchBinary(Binary binary,int i){
        if(null ==binary){
            return false;
        }
        int data = (int)binary.data;
        if(data < i){
            return searchBinary(binary.rBinary,i);
        }else if(data > i){
            return searchBinary(binary.lBinary,i);
        }else{
            return true;
        }
    }
    /**插入值*/
    Binary insertBinary(Binary binary,int i){
        int data =(int) binary.data;
        if(i < data){
            Binary lBinary = binary.lBinary;
            if(null == lBinary){
                Binary binary1 = new Binary(null,null,i);
                lBinary = binary1;
            }else{
                binary.lBinary = insertBinary(lBinary,i);
            }
        }else{
            Binary rBinary = binary.rBinary;
            if(null == rBinary){
                Binary binary1 = new Binary(null,null,i);
                rBinary = binary1;
            }else{
                binary.rBinary = insertBinary(rBinary,i);
            }
        }
        return binary;
    }

    /**打印树*/
    void printBinaryTree(Binary binary){
        Binary lBinary = binary.lBinary;
        Binary rBinary = binary.rBinary;
        if(binary != null){
            System.out.println(binary.data);
            if(lBinary != null){
                printBinaryTree(lBinary);
            }
            if(rBinary != null){
                printBinaryTree(rBinary);
            }
        }else{
            return ;
        }

    }
    @Test
    public void insertTest(){
        Binary binarys = insertBinary(binary,12);
        System.out.println(binarys);
    }
    @Test
    public void printTest(){
        printBinaryTree(binary);
    }
    @Test
    public void searchTree(){
        boolean bool = searchBinary(binary,12);
        System.out.println(bool);
    }


    /**树结点*/
    class Binary{
        Binary  lBinary;
        Binary rBinary;
        Object data;

        public Binary(Binary lBinary, Binary rBinary, Object data) {
            this.lBinary = lBinary;
            this.rBinary = rBinary;
            this.data = data;
        }
    }
}
