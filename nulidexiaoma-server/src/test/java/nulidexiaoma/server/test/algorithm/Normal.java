package nulidexiaoma.server.test.algorithm;

import org.junit.Test;

/**
 * Created by wenzailong on 2018/2/8.
 */
public class Normal {
    private  int[] a = new int[100000000];
    int key = 1;

    public Normal() {
        a[99999999] = 1;
    }

    @Test
    public void foreachTest(){

        Long begin = System.currentTimeMillis();
        System.out.println("begin:" + begin);
        for (int i = 0; i < a.length; i++) {
            if(a[i] == key){
                break;
            }

        }
        Long end = System.currentTimeMillis();
        System.out.println("end:" + end);
        System.out.println("result:" + (end-begin));
    }


    @Test
    public void whenTest(){
        Long begin = System.currentTimeMillis();
        System.out.println("begin:" + begin);
        int i = 0;
        while (a[i] != key) {
            i++;
        }
        Long end = System.currentTimeMillis();
        System.out.println("end:" + end);
        System.out.println("result:" + (end-begin));
    }
}
