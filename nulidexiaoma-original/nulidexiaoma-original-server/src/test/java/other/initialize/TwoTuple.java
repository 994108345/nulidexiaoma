package other.initialize;/**
 * Created by wenzailong on 2018/5/31.
 */

/**
 * @author wenzailong
 * @create 2018-05-31 16:35
 **/
public class TwoTuple<A,B> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
