package other.pattern.decorator.cloth;/**
 * Created by wenzailong on 2018/5/30.
 */

/**
 * @author wenzailong
 * @create 2018-05-30 10:18
 **/
public class Shoes extends Finery{
    @Override
    public void show() {
        System.out.println("鞋子");
        super.show();
    }
}
