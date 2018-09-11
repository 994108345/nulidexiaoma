package other.generic;/**
 * Created by wenzailong on 2018/6/4.
 */

/**
 * @author wenzailong
 * @create 2018-06-04 9:20
 **/
public class GenericTest {
    public<T> void fun(T t){
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        GenericTest gt = new GenericTest();
        gt.fun("");
        gt.fun(1);
        gt.fun('a');
        gt.fun(12L);
    }
}

class TestDemo<B>{
    public TestDemo(B b) {
        System.out.println(b.getClass().getName());
    }
    public TestDemo() {
        System.out.println("ok吗");
    }

    public static void main(String[] args) {
        TestDemo test = new TestDemo();
    }
}

class TestDemo2 implements  InterfaceDemo1{

    @Override
    public void PrintStr(Object o) {

    }
}

interface InterfaceDemo1<T>{
    void PrintStr(T t);
}
