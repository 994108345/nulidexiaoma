package other.thread.ThreadLocal;/**
 * Created by wenzailong on 2018/5/15.
 */

import java.util.Date;

/**
 * @author wenzailong
 * @create 2018-05-15 16:06
 **/
public class InheritableThreadLocalExt extends  InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + "我在子线程加的！！！";
    }
}
