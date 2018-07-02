package initialize;/**
 * Created by wenzailong on 2018/5/31.
 */

/**
 * @author wenzailong
 * @create 2018-05-31 9:12
 **/
public class OverLoad {
    public OverLoad() {
        this(1);
        int c = 12;

    }
    public OverLoad(int a) {
        short b = 1;
        System.out.println("呼呼");
    }


    /*void fun1(char a){
            System.out.println("fun1(char)");
        }*/
    /*void fun1(byte a){
        System.out.println("fun1(byte)");
    }*/
    void fun1(short a){
        System.out.println("fun1(short)");
    }
    /*void fun1(int a){
        int c = a +2;
        System.out.println(c);
        System.out.println("fun1(int)");
    }
    void fun1(long a){
        System.out.println("fun1(long)");
    }
    void fun1(float a){
        System.out.println("fun1(float)");
    }
    void fun1(double a){
        System.out.println("fun1(double)");
    }*/

    public static void main(String[] args) {
        OverLoad overLoad = new OverLoad();
        /*byte a = 12;
        overLoad.fun1(a);
        int b = 123456;
        overLoad.fun1(b);*/
    }
}
