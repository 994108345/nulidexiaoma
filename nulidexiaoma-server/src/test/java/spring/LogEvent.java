package spring;/**
 * Created by wenzailong on 2018/5/29.
 */

import org.springframework.context.ApplicationEvent;

/**
 * @author wenzailong
 * @create 2018-05-29 10:07
 **/
public class LogEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public LogEvent(Object source) {
        super(source);
    }
}
