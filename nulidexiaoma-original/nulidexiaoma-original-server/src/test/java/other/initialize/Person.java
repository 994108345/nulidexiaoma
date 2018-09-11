package other.initialize;/**
 * Created by wenzailong on 2018/5/31.
 */

/**
 * @author wenzailong
 * @create 2018-05-31 15:05
 **/
public class Person  {
    public final String first;
    public final String last;
    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    static class NullPerson extends Person implements Null{

        private NullPerson() {
            super("None", "None", "None");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }
    public static final Person Null = new NullPerson();
}

interface Null{}

