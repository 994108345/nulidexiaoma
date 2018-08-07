package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/8/6.
 */

import cn.wzl.nulidexiaoma.html.api.NIoDubboOfAsyncBService;
import org.springframework.stereotype.Service;

/**
 * @author wenzailong
 * @create 2018-08-06 19:30
 **/
@Service("nIoDubboOfAsyncBServiceImpl")
public class NIoDubboOfAsyncBServiceImpl implements NIoDubboOfAsyncBService {
    @Override
    public Object asyncB() throws InterruptedException {
        Thread.currentThread().sleep(1000*5);
        System.out.println("调用B");
        return "B";
    }
}
