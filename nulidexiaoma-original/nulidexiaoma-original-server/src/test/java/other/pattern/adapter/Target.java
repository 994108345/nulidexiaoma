package other.pattern.adapter;/**
 * Created by wenzailong on 2018/5/25.
 */

/** 客户所期待的接口：目标可以是具体的或抽象的类
 * @author wenzailong
 * @create 2018-05-25 15:12
 **/
public class Target {
    public void request(){
        System.out.println("普通请求");
    }
}

