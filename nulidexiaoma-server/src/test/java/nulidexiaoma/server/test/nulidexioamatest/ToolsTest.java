package nulidexiaoma.server.test.nulidexioamatest;

import cn.wzl.nulidexiaoma.model.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wenzailong on 2017/12/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ToolsTest {
    private Logger logger = LoggerFactory.getLogger(ToolsTest.class);

    /**
     * 对象转json字符串
     */
    @Test
    public void objectToJson(){
        User user = new User();
        user.setUserName("123");
        user.setPassWord("123");
        String str=JSON.toJSONString(user);
        System.out.println(str);

    }

    /**
     * 剪切数组
     */
    @Test
    public void listTest(){
        List list = new ArrayList<>();
        list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");
        list.add("2");list.add("2");list.add("2");list.add("2");list.add("2");list.add("2");list.add("2");list.add("2");
        List sublist = list.subList(0,16);
        System.out.println(sublist.toString());
    }

    /**
     * json字符串转object
     */
    @Test
    public void  jsonStrToObject(){
        String jsonStr = "{\n" +
                "  'userCode': 'HQ01UB993',\n" +
                "  'deviceId': '1111',\n" +
                "  'ipAddress': '192.168.31.230',\n" +
                "  'warhCode': 'HQ01W850',\n" +
                "  'password':'test',\n" +
                "  'token':'5fadaa5ceef109dacbb6625ceae409bc055c0bf956395f7755af9495e4b3f9ec',\n" +
                "  'data':[{\n" +
                "        'code': '102',\n" +
                "        'id': '635879C63D29E7C0E050640A97146D82',\n" +
                "        'menuName': '箱组盘收货',\n" +
                "        'parentId': '1',\n" +
                "        'sortId': 4\n" +
                "      }],\n" +
                "}";
        Object object = JSON.parse(jsonStr);
        System.out.println(object.toString());
    }

    @Test
    public void objectToOther(){
        User user = new User();
        Object obj =user;
        user = (User)obj;
    }

    /**
     * 生成随机数
     */
    @Test
    public void randowTest(){
        Random random = new Random();
        for(int i = 0 ; i<10;i++) {
            System.out.println(random.nextInt(10));
        }
    }

    /**
     * 测试移位运算符（显示的都是补码，正数的原码的补码反码一样，负数的补码等于正数的补码取反加1）
     */
    @Test
    public void shiftOperator(){
        int count = 10;
        int num = -4;
        System.out.println("二进制为"+Integer.toBinaryString(4));
        System.out.println("二进制为"+Integer.toBinaryString(-4));
        while(count>1){
            count--;
            num = num>>1;
            System.out.println("num:" + num);
            System.out.println("二进制为"+Integer.toBinaryString(num));
        }
    }

    /**
     * 测试引用传递（对象是引用传递、基本数据类型都是值传递,如果是new了，是不存在引用传递的！）
     */
    @Test
    public void referenceTest(){
        A node1 = new A("a","b",1,null);
        A node2 = new A("a","b",2,node1);

        A node = new A("213","123",1,null);
        A node3 = node2.object;


        node = node1;
        node.a = "123123213";


        System.out.println(node2.a);

    }
    class A{
        String a;
        String b;
        int c;
        A object;

        public A(String a, String b, int c, A object) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.object = object;
        }
    }

    @Test
    public void testInteger(){

        Integer a = null;
        try {
            a = null;
            Integer b = null;
            a = b;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
