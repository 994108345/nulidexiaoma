package pattern.proxy;/**
 * Created by wenzailong on 2018/5/23.
 */

/**
 * @author wenzailong
 * @create 2018-05-23 10:36
 **/
public class NoFly implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("我不会飞");
    }
}
