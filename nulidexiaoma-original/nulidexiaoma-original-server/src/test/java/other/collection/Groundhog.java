package other.collection;/**
 * Created by wenzailong on 2018/7/23.
 */

/**
 * @author wenzailong
 * @create 2018-07-23 10:18
 **/
public class Groundhog {
    protected int number;

    @Override
    public String toString() {
        return "Groundhog{" +
                "number=" + number +
                '}';
    }

    public Groundhog(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
