package other.generic;/**
 * Created by wenzailong on 2018/6/4.
 */

/**
 * @author wenzailong
 * @create 2018-06-04 17:47
 **/
public abstract class GenericWithCreate<T> {
    final T element;

    public GenericWithCreate() {
        this.element = create();
    }
    abstract T create();
}
class X{}
class Creator extends GenericWithCreate<X>{

    X create(){return new X();}
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}
class CreatorGeneric{
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}
