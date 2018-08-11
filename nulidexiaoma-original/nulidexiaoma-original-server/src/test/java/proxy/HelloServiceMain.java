package proxy;/**
 * Created by wenzailong on 2018/5/24.
 */

import org.junit.Test;

/**
 * @author wenzailong
 * @create 2018-05-24 9:57
 **/
public class HelloServiceMain {
    public static void main(String[] args) {
        /*创建代理对象*/
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        /*根据代理对象创建实际对象，然后调用接口*/
        HelloService proxy =(HelloService)helloServiceProxy.bind(new HelloServiceImpl());
        proxy.sayHello("张三");
    }
    @Test
    public void cglibTest(){
        HelloServiceCgLib cgLib = new HelloServiceCgLib();
        HelloServiceImpl service =(HelloServiceImpl)cgLib.getInstance(new HelloServiceImpl());
        service.sayHello("张三");
    }
}
