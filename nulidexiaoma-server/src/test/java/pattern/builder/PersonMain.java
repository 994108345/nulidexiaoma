package pattern.builder;/**
 * Created by wenzailong on 2018/5/24.
 */

/**
 * @author wenzailong
 * @create 2018-05-24 14:26
 **/
public class PersonMain {
    public static void main(String[] args) {
        PersonThinBuilder ptb = new PersonThinBuilder();
        PersonDirector pdThin = new PersonDirector(ptb);
        pdThin.CreatePerson();
    }
}
