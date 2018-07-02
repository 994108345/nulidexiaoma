package generic;/**
 * Created by wenzailong on 2018/6/4.
 */

/**
 * @author wenzailong
 * @create 2018-06-04 15:36
 **/
public class Hasf {
    public void f(){
        System.out.println("Hasf.f()");
    }
}
class Manipulator<T>{
    private T obj;
    public Manipulator(T x){
        this.obj = x;
    }
    public void mainpulate(){
        //obj.f();这么写编译不通过。因为此时的泛型的具体类型被擦除了，Wimbledon并不知道T是什么类型。
    }
}
class Manipulation{
    public static void main(String[] args) {
        Hasf hf = new Hasf();
        Manipulator<Hasf> manipulator = new Manipulator<Hasf>(hf);
        manipulator.mainpulate();
    }
}
class Manipulator2<T extends Hasf>{  //extend是的意思将T擦除为Hasf，即Hasf替换了T类型。
    private T  obj;

    public Manipulator2(T obj) {
        this.obj = obj;
    }
    public void manipulate(){
        obj.f();
    }
}
