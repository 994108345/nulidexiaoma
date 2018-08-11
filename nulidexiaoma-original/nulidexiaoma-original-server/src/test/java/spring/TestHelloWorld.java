package spring;/**
 * Created by wenzailong on 2018/5/29.
 */

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author wenzailong
 * @create 2018-05-29 9:06
 **/
public class TestHelloWorld {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ApplicationContext axtx = new FileSystemXmlApplicationContext("config.xml");
        HelloWorld helloWorld = (HelloWorld)axtx.getBean("HelloWorld");
        System.out.println(helloWorld.getMsg());
    }
}
