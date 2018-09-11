package other.pattern.invoke;/**
 * Created by wenzailong on 2018/5/25.
 */

/**
 * @author wenzailong
 * @create 2018-05-25 9:34
 **/
public class BakeChickenWingCommand extends Command {


    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void excuteCommand() {
        receiver.bakeChickenWing();
    }
}
