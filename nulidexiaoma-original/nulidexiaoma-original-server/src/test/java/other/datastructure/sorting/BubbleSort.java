package other.datastructure.sorting;/**
 * Created by wenzailong on 2018/7/19.
 */

import org.junit.Test;

/**
 * @author wenzailong
 * @create 2018-07-19 10:59
 **/
public class BubbleSort {



    @Test
    public void normalBubble(){
        int[] a = {1,5,9,12,6,245,12,56,5,3,6,4,1,5,8,64,3,3,32,5,7,45,1,8,3,0,4,7,10};
        int sortTime = 0;
        int middle;
        for (int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length-i-1; j++){
                int front = a[j];
                int behind = a[j+1];
                if(front > behind){
                    middle = front;
                    a[j] = behind;
                    a[j+1] = middle;
                }
                sortTime++;
            }
        }
        System.out.println("normalBubble-sortTime:"+sortTime);
    }
    @Test
    public void  improveBubble(){
        int[] a = {1,0,1,1,3,3,3,3,4,4};
        int middle;
        int sortTimes = 0;
        for (int i = 0; i < a.length; i++) {
            boolean isSwop = false;
            for(int j = 0; j < a.length-i-1; j++){
                int front = a[j];
                int behind = a[j+1];
                if(front > behind){
                    middle = front;
                    a[j] = behind;
                    a[j+1] = middle;
                    isSwop = true;
                }
                sortTimes++;

            }
            if(!isSwop){
                break ;
            }
        }
        System.out.println(sortTimes);
    }


    @Test
    public void test(){
        //normalBubble();
        improveBubble();
        /*for (int i : a) {
            System.out.print(i+",");
        }*/
    }


}
