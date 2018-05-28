package proxy;/**
 * Created by wenzailong on 2018/5/23.
 */

import java.lang.reflect.Method;

/**
 * @author wenzailong
 * @create 2018-05-23 17:57
 **/
public class Reflection {
    public void getName(String name){
        System.out.println("我的名字叫做" + name);
    }

    public static void main(String[] args) {
        try{
            Object ob = Class.forName(Reflection.class.getName()).newInstance();
            Method method = ob.getClass().getMethod("getName",String.class);
            method.invoke(ob,"nulidexiaoma");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
