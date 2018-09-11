package other.proxy;/**
 * Created by wenzailong on 2018/5/24.
 */

import java.lang.reflect.*;

/**
 * @author wenzailong
 * @create 2018-05-24 9:07
 **/
public class HelloServiceProxy implements InvocationHandler {
    /*真实服务对象*/
    private Object target;

    public Object bind(Object target){
        this.target = target;
        /*JDK生成一个代理对象，有三个参数，第一个是类加载器，第二个是接口，第三个是代表当前类的this*/
        Object object = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        return object;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method 当前调用的的那个方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我的JDK动态代理");
        Object result = null;
        System.out.println("我准备说hello");
        /*调用方法*/
        result = method.invoke(target,args);
        System.out.println("我说过hello了");
        return result;
    }
}
