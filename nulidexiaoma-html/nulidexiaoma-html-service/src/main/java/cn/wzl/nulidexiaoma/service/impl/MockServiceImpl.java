package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/8/8.
 */

import cn.wzl.nulidexiaoma.html.api.MockService;
import org.springframework.stereotype.Service;

/**
 * @author wenzailong
 * @create 2018-08-08 16:57
 **/
@Service
public class MockServiceImpl implements MockService {
    @Override
    public String sayHello(String name) {
        System.out.println("MockServiceImpl-"+name);
        return name;
    }
}
