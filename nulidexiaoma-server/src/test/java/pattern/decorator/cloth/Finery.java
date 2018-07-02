package pattern.decorator.cloth;/**
 * Created by wenzailong on 2018/5/30.
 */

/**服装类
 * @author wenzailong
 * @create 2018-05-30 10:12
 **/
public class Finery extends  Person {
    protected Person component;

    public void decorate(Person component){
        this.component = component;
    }

    @Override
    public void show() {
        if(component != null){
            component.show();

        }
    }
}
