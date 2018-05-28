package pattern.proxy;/**
 * Created by wenzailong on 2018/5/23.
 */

/**
 * @author wenzailong
 * @create 2018-05-23 10:54
 **/
public class Main {
    public static void main(String[] args) {
        Duck greenDuck = new GreenDuck();
        greenDuck.setFlyBehavior(new FlyWithWings());
        greenDuck.performFly();
        System.out.println("你的翅膀受到了永久性伤害不能飞了");
        greenDuck.setFlyBehavior(new NoFly());
        greenDuck.performFly();
    }
}
