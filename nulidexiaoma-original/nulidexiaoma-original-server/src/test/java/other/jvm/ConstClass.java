package other.jvm;/**
 * Created by wenzailong on 2018/6/22.
 */

/**
 * @author wenzailong
 * @create 2018-06-22 13:46
 **/
public class ConstClass {
    static{
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORLD = "hello world";
}
