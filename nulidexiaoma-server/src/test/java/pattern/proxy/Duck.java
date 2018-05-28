package pattern.proxy;/**
 * Created by wenzailong on 2018/5/22.
 */

/**
 * @author wenzailong
 * @create 2018-05-22 17:30
 **/
public class Duck {
    private FlyBehavior flyBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performFly(){
        flyBehavior.fly();
    }
}
