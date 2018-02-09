package nulidexiaoma.server.test.algorithm;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.codec.BinaryEncoder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二叉排序树
 */
public class BinaryTreeSort {
    private Binary binary;

    public BinaryTreeSort() {
        Binary binary12 = new Binary(null,null,4);
        Binary binary13 = new Binary(null,null,7);
        Binary binary11 = new Binary(binary12,binary13,5);
        Binary binary10 = new Binary(null,null,1);
        Binary binary9 = new Binary(binary10,binary11,3);



        Binary binary8 = new Binary(null,null,11);
        Binary binary14 = new Binary(null,null,9);
        Binary binary4 = new Binary(binary9,binary14,8);
        Binary binary5 = new Binary(binary8,null,12);
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
                binary.rBinary = new Binary(null,null,i);
            }else{
                lBinary = insertBinary(lBinary,i);
            }
        }else{
            Binary rBinary = binary.rBinary;
            if(null == rBinary){
                binary.rBinary = new Binary(null,null,i);
            }else{
                rBinary = insertBinary(rBinary,i);
            }
        }
        return binary;
    }
    /**删除结点*/
    Binary deleteBinary(int deleteNode,Binary binary){
        int data =(int) binary.data;
        if(deleteNode < data){
            Binary lBinary = binary.lBinary;
            if (null != lBinary){
                binary.lBinary = deleteBinary(deleteNode,lBinary);
            }
        }else if (deleteNode > data){
            Binary rBinary = binary.rBinary;
            if (null != rBinary){
                binary.rBinary = deleteBinary(deleteNode,rBinary);
                System.out.println();
            }
        }else{
            Binary lBinary = binary.lBinary;
            Binary rBinary = binary.rBinary;
            if(null ==lBinary && null !=rBinary){
                return rBinary;
            }
            if(null !=lBinary && null ==rBinary){
                return lBinary;
            }
            if(null ==lBinary && null ==rBinary){
                return null;
            }
            if(null !=lBinary && null !=rBinary){
                Binary rrBinary = lBinary.rBinary;
                if( null == rrBinary){
                    rrBinary.rBinary = rBinary;
                    return rrBinary;
                }else{
                    Map map = recursiveRight(rrBinary);
                    lBinary = (Binary)map.get("binary");
                    binary = (Binary)map.get("delete");
                    binary.lBinary = lBinary;
                    binary.rBinary = rBinary;
                    return binary;
                }
            }
        }
        return binary;
    }
    /**循环左子树*/
    Map recursiveRight(Binary binary){
        Map map = new HashMap<>();
        Binary rBinary = binary.rBinary;
        if( null != rBinary){
            if(rBinary.rBinary!=null){
                map = recursiveRight(rBinary);
                binary.rBinary =(Binary) map.get("binary");
                map.put("binary",binary);
            }else{
                map.put("delete",rBinary);
                if(null != rBinary.lBinary ){
                    binary.rBinary = rBinary.lBinary;
                    map.put("binary",binary);
                    return map;
                }
            }
        }
        return map;
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
    public void deleteNode(){
        Binary binary1 = deleteBinary(8,binary);
        System.out.println(binary1);
    }
    @Test
    public void insertTest(){
        Binary binarys = insertBinary(binary,13);
;        System.out.println(binarys);
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
