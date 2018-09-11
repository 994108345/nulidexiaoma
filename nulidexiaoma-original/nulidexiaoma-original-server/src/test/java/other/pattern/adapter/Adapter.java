package other.pattern.adapter;/**
 * Created by wenzailong on 2018/5/25.
 */

/**通过在内部类包装一个Adaptee对象，把源接口转换成目标接口
 * @author wenzailong
 * @create 2018-05-25 15:14
 **/
public class Adapter extends Target{
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
