package nulidexiaoma.server.test;

import cn.wzl.nulidexiaoma.api.IRedisService;
import cn.wzl.nulidexiaoma.common.redis.CacheProxy;
import cn.wzl.nulidexiaoma.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by wenzailong on 2018/2/27.
 * redis连接
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class RedisConnection {

    @Autowired
    CacheProxy cacheProxy;
    @Autowired
    IRedisService redisService;

    public static void main(String[] args) {
        //连接本地的 redis 服务
        Jedis jedis = new Jedis("localhost");
        jedis.auth("bobobobo");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
    }

    /**
     * string类型
     */
    @Test
    public void redisString() {
        //连接本地的 redis 服务
        Jedis jedis = new Jedis("localhost");
        jedis.auth("bobobobo");
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
    }

    /**
     * 列表类型
     */
    @Test
    public void redisList() {
        //连接本地的 redis 服务
        Jedis jedis = new Jedis("localhost");
        jedis.auth("bobobobo");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + list.get(i));
        }
    }

    @Test
    public void redisAddList() {
        //连接本地的 redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        User user = new User();
        user.setUserName("张三");
        user.setPassWord("123");
        //存储数据到列表中
        jedis.lpush("site-list", "11111");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + list.get(i));
        }
    }

    /**
     * key
     */
    @Test
    public void getOne(){
        cacheProxy.set("one","11111");
        String a = cacheProxy.get("one");
        System.out.println(a);

        try {
            cacheProxy.lpush("a" ,"2123");
            cacheProxy.lrange("a",1,2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void serLKey() throws Exception {

    }
}
