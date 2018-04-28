package nulidexiaoma.server.test.other.dynamicproxy;/**
 * Created by wenzailong on 2018/4/26.
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wenzailong
 * @create 2018-04-26 17:33
 **/
public class HelloServiceCgLib implements MethodInterceptor{
    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return  enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("##############我的cglib的动态代理##########");
        //反射方法前调用
        System.err.println("我准备说hello}");
        Object returnObj = methodProxy.invokeSuper(o,objects);
        //反射方法后调用
        System.err.println("我说过hello了");
        return returnObj;
    }
}
