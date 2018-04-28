package nulidexiaoma.server.test.other.algorithm;

import org.junit.Test;

/**
 * 斐波那契查找（黄金分割）
 */
public class Feibonaqi {

    int[] F = new int[100];
    int low;
    int high;
    int mid;

    public Feibonaqi() {
        F[0] = 1;
        F[1] = 5;
        F[2] = 12;
        F[3] = 31;
        F[4] = 42;
        F[5] = 44;
        F[6] = 59;
        F[7] = 99;
        F[8] = 222;
        F[9] = 1000;
        low = 0;
        high = 9;
    }
    /**斐波那契查找*/
    int feiboSerach(int key) throws Exception {
        int fibonacci[] = getFeibonaqiArr(10);
        int k = 0;
        /*算出key在斐波那契数列中的值*/
        for (int i = 0; i < fibonacci.length; i++) {
            if(fibonacci[i]>key){
                k=i;
                break;
            }
        }
        int n = fibonacci[k];
        /*补全序列*/
        while(n>high){
            F[high+1] = F[high];
            n--;
        }
         while(low<=high){
            mid = low + F[k-1] -1;
            if(key < F[mid]){
                high = mid-1;
                k=k-1;
            }else if(key > F[mid]){
                low = mid +1;
                k = k-2;
             }else{
                if(mid <=n){
                    return mid;
                }else{
                    return n;
                }
            }
         }
        return 0;
    }

    @Test
    public void fibonacci() throws Exception {
        int result = feiboSerach(34);
        System.out.println(result);
    }

    /**获得斐波那契数列*/
    int[] getFeibonaqiArr(int i) throws Exception {
        int[] feibonaqi = new int[100];
        feibonaqi[0] = 0;
        feibonaqi[1] = 1;
        if(i<3){
            throw new Exception("斐波那契数列的长度要大于3");
        }
        int index = 2;
        int[] f = calculateFeibo(2,i-2,feibonaqi);
        return f;
    }

    int[] calculateFeibo(int n,int i,int[] feibo){
        if(i==0){
            return feibo;
        }
        feibo[n] = feibo[n-1] + feibo[n-2];
        n++;
        i--;
        feibo = calculateFeibo(n,i,feibo);
        return feibo;
    }
    @Test
    public void getFeibo() throws Exception {
       int[] f = getFeibonaqiArr(55);
        for (int i : f) {
            System.out.print(i+",");
        }
    }
    @Test
    public void goldenTest() throws Exception {
        int[] f = getFeibonaqiArr(55);
        double a = 0.0000;
        for (int i = 5; i < 20; i++) {
            a= (double)(f[i-1]-1)/(double)(f[i-2]-1);
            System.out.println(a);
        }
    }
}
