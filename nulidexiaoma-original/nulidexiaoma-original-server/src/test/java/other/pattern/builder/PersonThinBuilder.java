package other.pattern.builder;/**
 * Created by wenzailong on 2018/5/24.
 */

/**
 * @author wenzailong
 * @create 2018-05-24 14:21
 **/
public class PersonThinBuilder extends PersonBuilder{
    @Override
    public void buildHead() {
        System.out.println("瘦人尖嘴猴腮");
    }

    @Override
    public void buildBody() {
        System.out.println("瘦人看不到肚子");
    }

    @Override
    public void buildArmLeft() {
        System.out.println("瘦人细左臂");
    }

    @Override
    public void buildArmRight() {
        System.out.println("瘦人细右臂");
    }

    @Override
    public void buildLegLeft() {
        System.out.println("瘦人细左腿");
    }

    @Override
    public void buildLegRight() {
        System.out.println("瘦人细右腿");
    }
}
