package pattern;/**
 * Created by wenzailong on 2018/5/22.
 */

/**
 * @author wenzailong
 * @create 2018-05-22 17:33
 **/
public class GreenHeadDuck extends Duck {
    public GreenHeadDuck() {
        System.out.println("I am a greenHeadDuck");
    }
    public void head(){
        System.out.println("我的头的绿的。。。。。。");
    }

    @Override
    public void display() {
        System.out.println("我是绿头鸭");
    }
    public void display(String name) {
        System.out.println("我叫" + name);
    }
}
