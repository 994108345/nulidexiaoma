package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/8/8.
 */

import cn.wzl.nulidexiaoma.api.NotifyService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenzailong
 * @create 2018-08-08 8:56
 **/
@Service
public class NotifyServiceImpl implements NotifyService {

    public Map<Integer, String> ret    = new HashMap<Integer, String>();
    public Map<Integer, Throwable> errors = new HashMap<Integer, Throwable>();

    @Override
    public void onreturn(String msg, String id) {
        System.out.println("onreturn:" + msg);
        System.out.println("事件通知-服务被调用时");
    }

    @Override
    public void onthrow(Throwable ex, Integer id) {
        errors.put(id, ex);
        System.out.println("事件通知-服务报错时");
    }

    @Override
    public void oninvoke(String name) {
        System.out.println("事务通知-调用之前");
    }
}
