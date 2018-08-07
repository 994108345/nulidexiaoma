package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/8/7.
 */

import cn.wzl.nulidexiaoma.html.api.CallBackService;
import cn.wzl.nulidexiaoma.html.api.CallbackListener;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**参数回调
 * @author wenzailong
 * @create 2018-08-07 19:03
 **/
@Service
public class CallBackServiceImpl implements CallBackService {
    private final Map<String,CallbackListener> listeners = new ConcurrentHashMap<String,CallbackListener>();

    public CallBackServiceImpl() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    try {
                        for(Map.Entry<String, CallbackListener> entry : listeners.entrySet()){
                            try {
                                entry.getValue().changed(getChanged(entry.getKey()));
                            } catch (Throwable t) {
                                listeners.remove(entry.getKey());
                            }
                        }
                        Thread.sleep(5000); // 定时触发变更通知
                    } catch (Throwable t) { // 防御容错
                        t.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void addListener(String key, CallbackListener listener) {
        listeners.put(key, listener);
        listener.changed(getChanged(key)); // 发送变更通知
    }

    private String getChanged(String key) {
        return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
