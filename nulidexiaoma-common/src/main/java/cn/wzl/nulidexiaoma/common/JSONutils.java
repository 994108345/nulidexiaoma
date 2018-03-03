package cn.wzl.nulidexiaoma.common;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by wenzailong on 2018/3/2.
 */
public class JSONutils<T> {
    /**
     * 对象转字符串
     * @param object
     */
    public static String ObjectToJson(Object object){
        String str=JSON.toJSONString(object);
        return str;
    }

    /**
     * josn字符串转对象
     * @param jsonStr
     */
    public static <T> T jsonStrToObj(String jsonStr,Class<T> objectClass) throws Exception {
        try {
            JSONObject jsStr = JSONObject.parseObject(jsonStr);
            if(jsStr instanceof  JSONObject){
                return JSON.toJavaObject((JSON) jsStr, objectClass);
            }else{
                throw new Exception("传入的不是json对象");
            }
        } catch (Exception e) {
            throw new Exception("传入的不是json字符串" + e.getMessage());
        }

    }
}
