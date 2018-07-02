package generic;/**
 * Created by wenzailong on 2018/6/4.
 */

/**
 * @author wenzailong
 * @create 2018-06-04 16:01
 **/
public class GenericBase<T> {
    private T element;

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
}
class Derived1<T> extends GenericBase<T>{}
class Derived2 extends GenericBase{}


class ReasureAndInheritance{

    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.getElement();
        d2.setElement(obj);
    }
}
