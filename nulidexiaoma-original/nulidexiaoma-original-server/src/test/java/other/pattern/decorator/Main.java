package other.pattern.decorator;/**
 * Created by wenzailong on 2018/5/30.
 */

/**
 * @author wenzailong
 * @create 2018-05-30 9:56
 **/
public class Main {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.operation();
    }
}
