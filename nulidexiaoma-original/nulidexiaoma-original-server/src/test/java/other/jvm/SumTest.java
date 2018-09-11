package other.jvm;/**
 * Created by wenzailong on 2018/6/25.
 */

/**
 * @author wenzailong
 * @create 2018-06-25 14:46
 **/
public class SumTest {
    public int calc(){
        int a = 100;
        int b = 200 ;
        int c = 300;
        return (a + b) * c;
    }
    public static void main(String[] args) {
        SumTest sumTest = new SumTest();
        sumTest.calc();
    }
}
