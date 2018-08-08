package cn.wzl.nulidexiaoma.api;/**
 * Created by wenzailong on 2018/8/8.
 */

/**
 * @author wenzailong
 * @create 2018-08-08 8:56
 **/
public interface NotifyService {
    /**
     * 事件通知(调用之后)
     * @param msg
     * @param id
     */
    void onreturn(String msg, String id);

    /**
     * 事件通知(抛异常后)
     * @param ex
     * @param id
     */
    void onthrow(Throwable ex, Integer id);

    /**
     * 调用之前
     * @param name
     */
    void oninvoke(String name);
}
