package nulidexiaoma.server.test.algorithm;

/**
 * 插值表达式
 */
public class InsertValue {
    int[] arr = new int[10];
    private int begin;
    private int end;

    public InsertValue() {
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
    /*书*/
    public boolean half(int i){
        int middleIndex;
        while(end >= begin) {
            middleIndex = (i-arr[begin])/(arr[end] - arr[begin]);
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
}
