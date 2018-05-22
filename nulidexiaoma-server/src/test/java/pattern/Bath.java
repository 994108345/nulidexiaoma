package pattern;/**
 * Created by wenzailong on 2018/5/22.
 */

/**
 * @author wenzailong
 * @create 2018-05-22 16:25
 **/
public class Bath {
    private String s1 = "Happy",s2 = "Happy",s3,s4;
    private Soap castille;
    private int i;
    private float toy;

    public Bath() {
        System.out.println("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }
    {i = 47;}

    @Override
    public String toString() {
        if(s4 == null){
            s4 = "joy";
        }
        return "Bath{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                ", s4='" + s4 + '\'' +
                ", castille=" + castille +
                ", i=" + i +
                ", toy=" + toy +
                '}';
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }
}


class A{
    void fun1(){}
    void fun2(){}
    void fun3(){}
    void fun4(){}

    public A() {
        System.out.println("A");
    }
}

class B extends A{
    public B() {
        System.out.println("B");
    }

    public static void main(String[] args) {
        B b = new B();
    }
}
