package other.collection;/**
 * Created by wenzailong on 2018/5/30.
 */

/**
 * @author wenzailong
 * @create 2018-05-30 16:28
 **/
public class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
