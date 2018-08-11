package pattern.decorator.cloth;/**
 * Created by wenzailong on 2018/5/30.
 */

/**
 * @author wenzailong
 * @create 2018-05-30 10:38
 **/
public class Hat extends  Finery {
    @Override
    public void show() {
        System.out.println("帽子");
        super.show();
    }
}
