package nulidexiaoma.server.test.other.dynamicproxy;/**
 * Created by wenzailong on 2018/4/26.
 */

/**
 * @author wenzailong
 * @create 2018-04-26 16:40
 **/
public class HelloServiceImpl implements  HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
