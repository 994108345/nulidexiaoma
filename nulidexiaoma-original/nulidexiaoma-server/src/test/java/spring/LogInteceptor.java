package spring;/**
 * Created by wenzailong on 2018/5/29.
 */

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.*;
import org.springframework.aop.support.IntroductionInfoSupport;

import java.lang.reflect.Method;

/**
 * @author wenzailong
 * @create 2018-05-29 11:04
 **/
public class LogInteceptor implements IntroductionAdvisor,IntroductionInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }

    @Override
    public ClassFilter getClassFilter() {
        return null;
    }

    @Override
    public void validateInterfaces() throws IllegalArgumentException {

    }

    @Override
    public Advice getAdvice() {
        return null;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    @Override
    public boolean implementsInterface(Class<?> intf) {
        return false;
    }

    @Override
    public Class<?>[] getInterfaces() {
        return new Class[0];
    }
}
