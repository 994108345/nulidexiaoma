package other.datastructure.sorting;/**
 * Created by wenzailong on 2018/7/19.
 */

import org.junit.Test;

/**
 * @author wenzailong
 * @create 2018-07-19 15:12
 **/
public class InsertSort {
    @Test
    public void insertSort(){
        int[] arr = {0,2,3,1,5,8,9,7,4,6};
        int flag = 0;//哨兵的下标
        int middle = 0;//中间值
        for (int i = 0; i < arr.length-1; i++) {
            arr[flag] = arr[i+1];
            flag = i+1;
            for (int j = 0; j < i; j++) {
                if(arr[i-j]<arr[i-j-1]){
                    middle = arr[i-j];
                    arr[i-j] = arr[i-j-1];
                    arr[i-j-1] = middle;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i+",");
        }
    }
}
