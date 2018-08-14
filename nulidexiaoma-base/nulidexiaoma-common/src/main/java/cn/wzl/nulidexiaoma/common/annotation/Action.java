package cn.wzl.nulidexiaoma.common.annotation;/**
 * Created by wenzailong on 2018/8/13.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**日志管理的注解
 * @author wenzailong
 * @create 2018-08-13 16:25
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    String name();
}