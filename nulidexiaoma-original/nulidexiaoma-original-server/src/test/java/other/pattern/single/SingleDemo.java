package other.pattern.single;

/**
 * @author wenzailong
 * @create 2018-05-24 16:14
 **/
public class SingleDemo {
    public volatile static SingleDemo uniqueInstace ;

    private SingleDemo() {
    }

    public static SingleDemo getInstance(){
        if(uniqueInstace == null) {
            synchronized (SingleDemo.class) {
                if (uniqueInstace == null) {
                    uniqueInstace = new SingleDemo();
                } else {
                    return uniqueInstace;
                }
            }
        }
        return uniqueInstace;
    }
}
