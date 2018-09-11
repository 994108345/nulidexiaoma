package other.collection;/**
 * Created by wenzailong on 2018/6/6.
 */

import org.junit.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wenzailong
 * @create 2018-06-06 15:28
 **/
public class ArraysTest {
    @Test
    public void getArrayInfo(){
        Class<Arrays> arraysClass= Arrays.class;
        getParamInfo(arraysClass);
        getMethodInfo(arraysClass);
        getConstructInfo(arraysClass);
    }

    /**
     * 获得指定类的全局变量
     * @param aClass
     */
    public void getParamInfo(Class aClass){
        /*类属性*/
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(String.format("%s %s %s",Modifier.toString(field.getModifiers()),field.getType(),field.getName()));
        }
    }

    /**
     * 获得指定类的方法
     * @param aClass
     */
    public void getMethodInfo(Class aClass){
        /*方法名*/
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.print(Modifier.toString(method.getModifiers()) + " " + method.getReturnType() +" " + method.getName());
            Type[] types = method.getGenericParameterTypes();
            StringBuffer stringBuffer = new StringBuffer("(");
            for (Type type : types) {
                stringBuffer.append(parseType(type) + ",");
            }
            String resultStr = stringBuffer.substring(0,stringBuffer.length()-1);
            resultStr = resultStr +")";
            System.out.println(resultStr);
        }
    }

    /**
     * 获取指定类的构造函数
     * @param aClass
     */
    public void getConstructInfo(Class aClass){
        /*构造函数*/
        Constructor[] constructors = aClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(Modifier.toString(constructor.getModifiers()) + " " + constructor.getName());
            Type[] types = constructor.getGenericParameterTypes();
            StringBuffer stringBuffer = new StringBuffer("(");
            for (Type type : types) {
                stringBuffer.append(parseType(type) + ",");
            }
            String resultStr = stringBuffer.substring(0,stringBuffer.length()-1);
            resultStr = resultStr +")";
            System.out.println(resultStr);
        }

    }

    /**
     * 解析type
     * @param type
     * @return
     */
    public String parseType(Type type){
        if(type != null){
            String typeStr = new String(type.toString());
            /*去掉class*/
            String strs = typeStr.replaceAll("class","");
            strs = strs.trim();
            /*判断是否为数组*/
            if(strs.substring(0,1).equals("[")){
                String a = strs.substring(1,2);
                if(a.equals("......")){
                    return "[byte]";
                }else if (a.equals("S")){
                    return "[String]";
                }else if (a.equals("C")){
                    return "[char]";
                }else if (a.equals("....")){
                    return "[boolean]";
                }else if (a.equals("I")){
                    return "[int]";
                }else if (a.equals("D")){
                    return "[double]";
                }else if (a.equals("F")){
                    return "[float]";
                }
            }
            return strs;
        }
        return "";
    }
    @Test
    public void listRemove(){
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        /*迭代器*/
        /*for (Object o : list) {
            list.remove(o);
            System.out.println(o);
        }*/
        /*循环遍历*/
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(str);
            list.remove(str);
        }

    }

}
