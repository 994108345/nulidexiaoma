package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/8/6.
 */

import cn.wzl.nulidexiaoma.html.api.NIoDubboOfAsyncAService;
import org.springframework.stereotype.Service;

/**
 * @author wenzailong
 * @create 2018-08-06 19:29
 **/
@Service("nIoDubboOfAsyncAServiceImpl")
public class NIoDubboOfAsyncAServiceImpl implements NIoDubboOfAsyncAService {
    @Override
    public Object asyncA() throws InterruptedException {
        Thread.currentThread().sleep(1000*5);
        System.out.println("调用A");
        return "A";
    }
}
