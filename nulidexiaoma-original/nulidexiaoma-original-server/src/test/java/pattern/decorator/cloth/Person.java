package pattern.decorator.cloth;/**
 * Created by wenzailong on 2018/5/30.
 */

/**
 * @author wenzailong
 * @create 2018-05-30 10:11
 **/
public class Person {
    public Person() {
    }
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("装扮的"+name);
    }
}
