package datastructure.sorting;/**
 * Created by wenzailong on 2018/7/19.
 */

import org.junit.Test;

/**
 * @author wenzailong
 * @create 2018-07-19 14:10
 **/
public class EasyChoseSort {
    @Test
    public void easyChoseSort(){
        int[] a = {3,5,1,2,9,8,6,7,10,4};
        int middle = 0;//值交换的时候的中间值
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;//最小值的数组下标
            int left = a[i];
            for (int j = i+1; j < a.length; j++) {
                int right = a[j];
                if(left>right){
                    left = right;
                    minIndex = j;
                }
            }
            if(i != minIndex){
                middle = a[minIndex];
                a[minIndex] = a[i];
                a[i] = middle;
            }
        }
        for (int i : a) {
            System.out.print(i+",");
        }
    }
}
