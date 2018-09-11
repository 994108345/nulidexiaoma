package other.pattern.proxy;/**
 * Created by wenzailong on 2018/5/23.
 */

/**
 * @author wenzailong
 * @create 2018-05-23 10:35
 **/
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("我会用翅膀飞");
    }
}
