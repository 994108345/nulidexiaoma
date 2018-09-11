package other.generic;/**
 * Created by wenzailong on 2018/6/4.
 */

/**
 * @author wenzailong
 * @create 2018-06-04 17:07
 **/
public class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>>Foo2(F x) {
        this.x= (T) x.create();
    }
}
class IntegerFactory implements FactoryI<Integer>{

    @Override
    public Integer create() {
        return new Integer(0);
    }
}
class Widget{
    public static class Factory implements FactoryI<Widget>{

        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

class FactoryConstranint{
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
interface FactoryI<T>{
    T create();
}
