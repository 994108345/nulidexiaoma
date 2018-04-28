package nulidexiaoma.server.test.other.dynamicproxy;/**
 * Created by wenzailong on 2018/4/26.
 */

/**
 * @author wenzailong
 * @create 2018-04-26 17:28
 **/
public class HelloServiceMain {
    public static void main(String[] args) {
        HelloServiceProxy HelloHandler = new HelloServiceProxy();
        HelloService proxy = (HelloService)HelloHandler.bind(new HelloServiceImpl());
        proxy.sayHello("张三");
    }
}
