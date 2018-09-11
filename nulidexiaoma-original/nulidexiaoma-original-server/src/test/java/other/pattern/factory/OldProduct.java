package other.pattern.factory;/**
 * Created by wenzailong on 2018/7/19.
 */

/**
 * @author wenzailong
 * @create 2018-07-19 10:43
 **/
public class OldProduct implements IProduct{
    @Override
    public void method1() {
        System.out.println("old method1");
    }

    @Override
    public void method2() {
        System.out.println("old method2");
    }

    @Override
    public void method3() {
        System.out.println("old method3");
    }
}
