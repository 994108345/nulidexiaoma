package pattern.builder;/**
 * Created by wenzailong on 2018/5/24.
 */

/**
 * @author wenzailong
 * @create 2018-05-24 14:21
 **/
public class PersonFatBuilder extends  PersonBuilder{
    @Override
    public void buildHead() {
        System.out.println("胖人肥头大耳");
    }

    @Override
    public void buildBody() {
        System.out.println("胖人大肚子");
    }

    @Override
    public void buildArmLeft() {
        System.out.println("胖人粗左臂");
    }

    @Override
    public void buildArmRight() {
        System.out.println("胖人粗右臂");
    }

    @Override
    public void buildLegLeft() {
        System.out.println("胖人粗左腿");
    }

    @Override
    public void buildLegRight() {
        System.out.println("胖人粗右腿");
    }
}
