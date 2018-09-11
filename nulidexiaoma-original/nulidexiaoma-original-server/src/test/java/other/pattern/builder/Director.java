package other.pattern.builder;/**
 * Created by wenzailong on 2018/5/24.
 */

/**指挥者类：用在指挥建造过程
 * @author wenzailong
 * @create 2018-05-24 14:59
 **/
public class Director {
    public void Construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }
}
