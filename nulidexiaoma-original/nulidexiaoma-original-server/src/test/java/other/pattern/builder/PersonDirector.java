package other.pattern.builder;/**
 * Created by wenzailong on 2018/5/24.
 */

/**
 * @author wenzailong
 * @create 2018-05-24 14:20
 **/
public class PersonDirector {
    private PersonBuilder pb;

    public PersonDirector(PersonBuilder pb) {
        this.pb = pb;
    }

    public void CreatePerson(){
        pb.buildHead();
        pb.buildBody();
        pb.buildArmLeft();
        pb.buildArmRight();
        pb.buildLegLeft();
        pb.buildLegRight();
    }
}
