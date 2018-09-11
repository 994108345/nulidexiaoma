package other.pattern.invoke;/**
 * Created by wenzailong on 2018/5/25.
 */

/**
 * @author wenzailong
 * @create 2018-05-25 10:11
 **/
public class Main {
    public static void main(String[] args) {
        Barbecuer boy = new Barbecuer();//命令执行者
        Command bakeMuttonCommand1 = new BakeChickenWingCommand(boy);
        Command bakeMuttonCommand2 = new BakeChickenWingCommand(boy);
        Command bakeChickenWingCommand1 = new BakeChickenWingCommand(boy);
        Command bakeChickenWingCommand2 = new BakeChickenWingCommand(boy);
        Waiter girl = new Waiter();
        girl.setOrder(bakeMuttonCommand1);
        girl.setOrder(bakeMuttonCommand2);
        girl.setOrder(bakeChickenWingCommand1);
        girl.setOrder(bakeChickenWingCommand2);
        girl.cancelOrder(bakeMuttonCommand1);
        girl.Notify();
    }
}
