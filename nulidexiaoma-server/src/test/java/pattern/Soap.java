package pattern;/**
 * Created by wenzailong on 2018/5/22.
 */

/**
 * @author wenzailong
 * @create 2018-05-22 16:25
 **/
public class Soap {
    private String s;

    public Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}
