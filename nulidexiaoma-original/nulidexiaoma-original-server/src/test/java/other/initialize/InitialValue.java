package other.initialize;/**
 * Created by wenzailong on 2018/5/31.
 */

/**
 * @author wenzailong
 * @create 2018-05-31 11:11
 **/
public class InitialValue {
    int i = f();
    String a;
    Book book;

    int f(){
        return 11;
    }

    public static void main(String[] args) {
        InitialValue initialValue = new InitialValue();
        System.out.println("i"+initialValue.i);
        System.out.println("a"+initialValue.a);
        System.out.println("book"+initialValue.book);
    }
}
