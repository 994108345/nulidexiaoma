package nulidexiaoma.server.test.nulidexioamatest;/**
 * Created by wenzailong on 2018/4/26.
 */

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wenzailong
 * @create 2018-04-26 16:19
 **/
public class Reflect {

    @Test
    public void reflectTest(){
        try {
            String className = ReflectService.class.getName();
            Object service = Class.forName(ReflectService.class.getName()).newInstance();
            Method method = service.getClass().getMethod("sayHello",String.class);
            method.invoke(service,"反射");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
class ReflectService{
    public void sayHello(String name){
        System.out.println("hello," + name + "!");
    }
}
