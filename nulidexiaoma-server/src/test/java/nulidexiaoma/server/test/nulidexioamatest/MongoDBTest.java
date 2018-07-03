package nulidexiaoma.server.test.nulidexioamatest;/**
 * Created by wenzailong on 2018/7/2.
 */

import cn.wzl.nulidexiaoma.common.exception.NulidexiaomaException;
import cn.wzl.nulidexiaoma.common.mongodb.MongoDBUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wenzailong
 * @create 2018-07-02 15:40
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class MongoDBTest {
    @Test
    public void insertOneTest(){
        MongoDBDomain mongoDBDomain = new MongoDBDomain();
        mongoDBDomain.setAge("100");
        try {
            /*MongoDBUtils.insertOne(mongoDBDomain);*/
            MongoDBUtils.insertOneWithCollectionName(mongoDBDomain,"wzl");
            System.out.println("OK");
        } catch (NulidexiaomaException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void findOne(){
        MongoDBDomain mongoDBDomain = new MongoDBDomain();
        mongoDBDomain.setAge("100");
        try {
            /*MongoDBUtils.insertOne(mongoDBDomain);*/
            MongoDBDomain result = (MongoDBDomain) MongoDBUtils.findOne("age","100",MongoDBDomain.class);
            System.out.println("OK");
        } catch (NulidexiaomaException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    class MongoDBDomain{
        String id ;
        String name;
        String age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
