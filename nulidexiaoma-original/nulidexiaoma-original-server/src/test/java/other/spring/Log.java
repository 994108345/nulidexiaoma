package other.spring;/**
 * Created by wenzailong on 2018/5/29.
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author wenzailong
 * @create 2018-05-29 10:05
 **/
public class Log implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    public int log(String log){
        LogEvent event = new LogEvent(log);
        this.applicationContext.publishEvent(event);
        return 0;
    }
}
