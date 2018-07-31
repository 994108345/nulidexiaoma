package pattern.decorator;/**
 * Created by wenzailong on 2018/5/30.
 */

/**
 * @author wenzailong
 * @create 2018-05-30 9:52
 **/
public class ConcreteDecoratorA extends  Decorator {
    private String addedState;

    @Override
    public void operation() {
        addedState = "New State";
        System.out.println("具体装饰对象A的操作");
    }
}
