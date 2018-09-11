package other.spring;/**
 * Created by wenzailong on 2018/5/29.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
