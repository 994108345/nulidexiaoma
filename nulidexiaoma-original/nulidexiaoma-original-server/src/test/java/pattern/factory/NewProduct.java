package pattern.factory;/**
 * Created by wenzailong on 2018/7/19.
 */

/**
 * @author wenzailong
 * @create 2018-07-19 10:42
 **/
public class NewProduct implements  IProduct{
    @Override
    public void method1() {
        System.out.println("new method1");
    }

    @Override
    public void method2() {
        System.out.println("new method2");
    }

    @Override
    public void method3() {
        System.out.println("new method3");
    }
}
