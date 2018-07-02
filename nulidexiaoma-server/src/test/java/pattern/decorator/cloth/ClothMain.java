package pattern.decorator.cloth;/**
 * Created by wenzailong on 2018/5/30.
 */

/**
 * @author wenzailong
 * @create 2018-05-30 10:19
 **/
public class ClothMain {
    public static void main(String[] args) {
        Person p = new Person("nulidexiaoma");
        Shoes shoes = new Shoes();
        TShirts ts = new TShirts();
        Hat hat = new Hat();

        shoes.decorate(p);
        ts.decorate(shoes);
        hat.decorate(ts);
        hat.show();
    }
}
