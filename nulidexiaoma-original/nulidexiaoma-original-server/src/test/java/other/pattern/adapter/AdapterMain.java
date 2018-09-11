package other.pattern.adapter;/**
 * Created by wenzailong on 2018/5/25.
 */

/**
 * @author wenzailong
 * @create 2018-05-25 15:16
 **/
public class AdapterMain {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
