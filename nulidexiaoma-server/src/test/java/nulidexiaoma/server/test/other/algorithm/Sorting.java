package nulidexiaoma.server.test.other.algorithm;

import org.junit.Test;

/**
 * Created by wenzailong on 2018/2/22.
 */
public class Sorting {
    int[] arrs = new int[]{0,9,7,10,3,2,1,4,6,5};
    int size = arrs.length;
    /**交换数组元素*/
    int[] swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        return arr;
    }
    void printArr(int[] arrs){
        for (int i = 0; i < size; i++) {
            System.out.print(arrs[i] + ",");
        }
    }
    /**冒泡排序*/
    @Test
    public void bubbling(){
        boolean flag = true;
        for (int i =  0; i < size && flag; i++) {
            flag = false;
            for (int j = size - 2;j >= i;j--) {
                if(arrs[j] > arrs[j+1]){
                    arrs = swap(arrs,j,j+1);
                    flag = true;
                }
            }
        }
        printArr(arrs);

    }
    /**简单排序*/
    @Test
    public void easySort(){
        int min;
        for (int i = 0; i < size; i++) {
            min = i ;
            for (int j = i+1; j < size; j++) {
                if(arrs[min] > arrs[j]){
                    min = j;
                }
            }
            if(1 != min){
                swap(arrs,i,min);
            }
        }
        printArr(arrs);
    }
    /**直接插入排序*/
    @Test
    public void directlySort(){
        int i,j;
        for (i = 2; i < size; i++) {
            if(arrs[i] < arrs[i-1]){
                arrs[0] = arrs[i];
                for (j = i - 1; arrs[j] > arrs[0] ; j--) {
                    arrs[j + 1] = arrs[j];
                }
                arrs[j + 1] = arrs[0];
            }
        }
        printArr(arrs);
    }
    /**希尔排序算法*/
    @Test
    public void shellSort(){
        int i,j;
        int increment = size;
        do {
            increment = increment/3+1;
            for (i = increment+1; i < size; i++) {
                if (arrs[i] < arrs[i - increment]){
                    arrs[0] = arrs[i];
                    for ( j = i-increment; j > 0 && arrs[0]<arrs[j] ; j -= increment) {
                        arrs[j+increment] = arrs[0];
                    }
                    arrs[j + increment] = arrs[0];
                }

            }
        }
        while(increment > 1);
        printArr(arrs);
    }
}
