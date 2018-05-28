package pattern.invoke;/**
 * Created by wenzailong on 2018/5/25.
 */

/** 抽象命令 抽象命令类，只需确定执行命令是谁
 * @author wenzailong
 * @create 2018-05-25 9:19
 **/
public  abstract class Command {

    protected Barbecuer receiver;

    public Command(Barbecuer receiver){
        this.receiver = receiver;
    }
    /*执行命令*/
    public abstract  void excuteCommand();


}
