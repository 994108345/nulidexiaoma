package cn.wzl.nulidexiaoma.common;/**
 * Created by wenzailong on 2018/8/18.
 */

import java.util.UUID;

/**
 * @author wenzailong
 * @create 2018-08-18 17:23
 **/
public class UUIdUtils {
    /**
     * 获取一个uuid（带横线）
     * @return
     */
    public static String getOneUUId(){
        return UUID.randomUUID().toString();
    }

    /**
     * 获取一个uuid（不带横线）
     * @return
     */
    public static String getOneUUIdNoLine(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
