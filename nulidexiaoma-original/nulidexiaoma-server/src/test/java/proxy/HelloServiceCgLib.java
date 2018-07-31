package proxy;/**
 * Created by wenzailong on 2018/5/24.
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wenzailong
 * @create 2018-05-24 11:08
 **/
public class HelloServiceCgLib implements MethodInterceptor{
    /*真实对象*/
    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        /*回调方法*/
        enhancer.setCallback(this);
        /*创建代理对象*/
        return  enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我的CGLIB的动态代理");
        System.out.println("我准备说hello");
        Object returnObj = methodProxy.invokeSuper(o,objects);
        System.out.println("我说过hello了");
        return returnObj;
    }
}
