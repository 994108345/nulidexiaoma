package nulidexiaoma.server.test.other.proxy;/**
 * Created by wenzailong on 2018/4/27.
 */

/**
 * @author wenzailong
 * @create 2018-04-27 11:27
 **/
public class Proxy extends Subject{
    RealSubject realSubject;

    @Override
    public void Request() {
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.Request();
    }
}
