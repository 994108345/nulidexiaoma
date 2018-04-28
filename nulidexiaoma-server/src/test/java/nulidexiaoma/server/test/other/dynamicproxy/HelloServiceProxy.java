package nulidexiaoma.server.test.other.dynamicproxy;/**
 * Created by wenzailong on 2018/4/26.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wenzailong
 * @create 2018-04-26 16:41
 **/
public class HelloServiceProxy implements InvocationHandler {
    /*真是服务对象*/
    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target){
        this.target = target;
        /*jdk代理需要提供接口*/
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 通过代理对象调用方法首先进入这个方法
     * @param proxy --代理对象
     * @param method --被调用方法
     * @param args --方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("########我的JSK动态代理############");
        Object  result = null;
        System.err.println("我准备说hello");
        result = method.invoke(target,args);
        System.err.println("我说过hello了");
        return result;
    }
}

