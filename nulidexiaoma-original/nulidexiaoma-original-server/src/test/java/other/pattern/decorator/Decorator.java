package other.pattern.decorator;/**
 * Created by wenzailong on 2018/5/30.
 */

/**
 * @author wenzailong
 * @create 2018-05-30 9:50
 **/
public class Decorator extends  Component {
    protected  Component component;


    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        if(component !=null){
            component.operation();

        }
    }
}
