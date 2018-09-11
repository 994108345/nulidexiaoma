package other.thread.ThreadLocal;/**
 * Created by wenzailong on 2018/5/15.
 */

/**
 * @author wenzailong
 * @create 2018-05-15 16:01
 **/
public class ThreadLocalExt extends  ThreadLocal{
    @Override
    protected Object initialValue() {
        return "我是初值";
    }
}
