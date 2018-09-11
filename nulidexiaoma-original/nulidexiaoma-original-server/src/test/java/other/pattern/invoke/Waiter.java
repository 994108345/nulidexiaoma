package other.pattern.invoke;/**
 * Created by wenzailong on 2018/5/25.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wenzailong
 * @create 2018-05-25 9:19
 **/
public class Waiter {
    private List<Command> orders = new ArrayList<Command>();
    /*设置订单*/
    public void setOrder(Command command){
        if(command == null){
            System.out.println("服务员:不好意思，没有鸡翅了！");
        }else{
            orders.add(command);
            System.out.println("增加订单" + new Date());
        }
    }

    /*取消订单*/
    public void cancelOrder(Command command){
        orders.remove(command);
        System.out.println("取消订单" + new Date());
    }
    /*通知全部执行*/
    public void Notify(){
        for (Command order : orders) {
            order.excuteCommand();
        }
    }

}
