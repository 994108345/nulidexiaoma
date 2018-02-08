package nulidexiaoma.server.test.algorithm;

import org.junit.Test;

/**
 * 折半查找
 */
public class Half {
    int[] arr = new int[10];
    private int begin;
    private int end;

    public Half() {
        arr[0] = 1;
        arr[1] = 5;
        arr[2] = 12;
        arr[3] = 31;
        arr[4] = 42;
        arr[5] = 44;
        arr[6] = 59;
        arr[7] = 99;
        arr[8] = 222;
        arr[9] = 1000;
        begin = 0;
        end = arr.length - 1;

    }
    /*我*/
    public boolean halfMe(int i){
        int middleIndex;

        while(true) {
            middleIndex = ((end + begin) / 2);
            int middle = arr[middleIndex];
            if (middle > i) {
                end = middleIndex;
            } else if (middle < i){
                begin = middleIndex;
            }else{
                return true;
            }
            if(end == (begin+1)){
                if(arr[end] == i || arr[begin] == i){
                    return  true;
                }
                return false;
            }
        }
    }
    /*书*/
    public boolean half(int i){
        int middleIndex;
        while(end >= begin) {
            middleIndex = ((end + begin) / 2);
            int middle = arr[middleIndex];
            if (middle > i) {
                end = middleIndex-1;
            } else if (middle < i){
                begin = middleIndex+1;
            }else{
                return true;
            }
        }
        return false;
    }
    @Test
    public void demoTest(){
        boolean bool1 = halfMe(1000);
        System.out.println(bool1);
        boolean bool2 = half(1000);
        System.out.println(bool2);
    }
}
