package nulidexiaoma.server.test.nulidexioamatest;/**
 * Created by wenzailong on 2018/4/23.
 */

import jvm.Demo1;
import org.apache.xmlbeans.impl.regex.Match;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wenzailong
 * @create 2018-04-23 17:23
 **/
public class RegularExpression {
    @Test
    public void test1(){
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }
    @Test
    public void test2(){
        String regex = "w s aaa s dasdsda asdfdfas sfeadfdfafda";
        Pattern p = Pattern.compile("^a");
        String[] str = p.split(regex);
        System.out.println(str.toString());
        System.out.println(str[0]);
    }
    @Test
    public void test3(){
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }
    @Test
    public void test4(){
        String REGEX = "\\bcat\\b";
        String INPUT = "cat cat cat cattie cat";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    }
    @Test
    public void  IntegerTest(){
        try{
            String str = "";
            int a = Integer.parseInt(str);
            System.out.println(a);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void matchTest(){
        String str = "";
        try {
            boolean bool = str.matches("[0-9]+");
            System.out.println(bool);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo1(){
        class Demo{
            String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        List<Demo> objList = new ArrayList<>();
        Demo demo1 = new Demo();
        demo1.setName("1");
        Demo demo2 = new Demo();
        demo2.setName("2");
        Demo demo3 = new Demo();
        demo3.setName("3");
        Demo demo4 = new Demo();
        demo4.setName("4");
        objList.add(demo1);objList.add(demo2);objList.add(demo3);objList.add(demo4);
        for (int i = 0; i < objList.size(); i++) {
            Demo demo = objList.get(i);
            System.out.println(demo.getName());
            demo.setName("111");
            System.out.println(objList.get(i).getName());
        }
    }
    @Test
    public void demo2(){
        StringBuilder stringBUilder1 = new StringBuilder("1");
        StringBuilder stringBUilder2 = new StringBuilder("2");
        StringBuilder stringBUilder3 = new StringBuilder("3");
        List<StringBuilder> list = new ArrayList<>();
        list.add(stringBUilder1);
        list.add(stringBUilder2);
        list.add(stringBUilder3);
        for (int i = 0; i < list.size(); i++) {
            StringBuilder s = list.get(i);
            System.out.println(s);
            s.replace(0,1,"11");
            System.out.println(list.get(i).toString());
        }
    }

    @Test
    public void referenceTest(){
        int b = 1;
        List list = new ArrayList();
        list.add(b);
        b = 2;
        System.out.println(list.toString());
    }
    @Test
    public void referenceTest2(){
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Map map  = new HashMap<>();
        map.put("list",list);

        List firstList = (List)map.get("list");
        List updateList = firstList.subList(0,2);
        map.put("list",updateList);
        System.out.println(firstList);
    }
}
