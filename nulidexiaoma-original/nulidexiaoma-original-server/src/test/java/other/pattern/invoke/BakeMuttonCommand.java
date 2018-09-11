package other.pattern.invoke;/**
 * Created by wenzailong on 2018/5/25.
 */

/**烤羊肉命令：具体命令类，执行命令时，执行具体的行为。
 * @author wenzailong
 * @create 2018-05-25 9:30
 **/
public class BakeMuttonCommand extends Command{


    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void excuteCommand() {
        receiver.bakeMutton();
    }
}
