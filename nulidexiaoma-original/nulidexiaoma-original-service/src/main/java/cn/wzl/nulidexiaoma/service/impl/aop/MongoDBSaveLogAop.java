package cn.wzl.nulidexiaoma.service.impl.aop;/**
 * Created by wenzailong on 2018/8/13.
 */

import cn.wzl.nulidexiaoma.common.annotation.Action;
import cn.wzl.nulidexiaoma.common.exception.NulidexiaomaException;
import cn.wzl.nulidexiaoma.common.mongodb.MongoDBUtils;
import cn.wzl.nulidexiaoma.model.MongoDBLog;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wenzailong
 * @create 2018-08-13 15:18
 **/
@Component
@Aspect
public class MongoDBSaveLogAop {
    private static final Logger logger = LoggerFactory.getLogger(MongoDBSaveLogAop.class);
    /**
     * 管理员登录方法的切入点
     */
    /*@Pointcut("execution(* cn.wzl.nulidexiaoma.original..*.*(..))")
    public void loginCell(){
    }*/

    /*使用注解方法拦截*/
    @Pointcut("@annotation(cn.wzl.nulidexiaoma.common.annotation.Action)")
    public void annoactionCell(){}
    /**
     * 登录操作(后置通知)
     * @param joinPoint
     * @throws Throwable
     */
    /*@AfterReturning(value = "loginCell()", argNames = "joinPoint,object", returning = "object")
    public void loginLog(JoinPoint joinPoint, Object object) throws Throwable {
        if (joinPoint.getArgs() == null) {// 没有参数
            return;
        }
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        String params = JSON.toJSONString(object);
        MongoDBLog mongoDBLog = new MongoDBLog();
        mongoDBLog.setMethodName(methodName);
        mongoDBLog.setParams(params);
        MongoDBUtils.insertOne(mongoDBLog);
    }*/

    @Before("annoactionCell()")
    public void after(JoinPoint joinPoint) throws NulidexiaomaException {
        try{
            MethodSignature signature=(MethodSignature)joinPoint.getSignature();
            Method method=signature.getMethod();
            Action action=method.getAnnotation(Action.class);
            System.out.println("注解拦截方式:"+action.name());
            MongoDBLog mongoDBLog = new MongoDBLog();
            mongoDBLog.setMethodName(method.getName());
            MongoDBUtils.insertOne(mongoDBLog);
        }catch (Exception e){
            logger.error("springAop错误了"+ e.getMessage());
        }

    }
}
