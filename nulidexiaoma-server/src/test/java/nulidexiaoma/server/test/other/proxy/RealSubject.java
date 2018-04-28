package nulidexiaoma.server.test.other.proxy;/**
 * Created by wenzailong on 2018/4/27.
 */

/**
 * @author wenzailong
 * @create 2018-04-27 11:26
 **/
public class RealSubject  extends Subject{
    @Override
    public void Request() {
        System.out.println("真实的请求");
    }
}
