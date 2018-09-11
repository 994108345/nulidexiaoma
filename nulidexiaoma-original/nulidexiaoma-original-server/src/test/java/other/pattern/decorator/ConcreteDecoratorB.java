package other.pattern.decorator;/**
 * Created by wenzailong on 2018/5/30.
 */

/**
 * @author wenzailong
 * @create 2018-05-30 9:53
 **/
public class ConcreteDecoratorB extends  Decorator {
    @Override
    public void operation() {
        addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    private void addedBehavior(){

    }
}
