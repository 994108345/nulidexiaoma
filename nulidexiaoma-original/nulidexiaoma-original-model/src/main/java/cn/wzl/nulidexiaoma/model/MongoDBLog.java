package cn.wzl.nulidexiaoma.model;/**
 * Created by wenzailong on 2018/8/13.
 */

/**
 * @author wenzailong
 * @create 2018-08-13 15:36
 **/
public class MongoDBLog {
    private String methodName;
    private String params;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}
