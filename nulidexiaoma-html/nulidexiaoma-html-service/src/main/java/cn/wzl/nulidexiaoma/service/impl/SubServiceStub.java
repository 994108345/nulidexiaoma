package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/8/8.
 */

import cn.wzl.nulidexiaoma.html.api.SubService;
import org.springframework.stereotype.Service;

/**
 * @author wenzailong
 * @create 2018-08-08 14:17
 **/
@Service
public class SubServiceStub implements SubService {
    private final SubService subService;

    public SubServiceStub(SubService subService) {
        this.subService = subService;
    }

    public String sayHello(String name){
        try{
            System.out.println("我是SubServiceStub");
            String message = subService.sayHello(name);
            System.out.println("subService.sayHello(name)结果是：" + message);
            return message;
        }catch (Exception e){
            System.out.println("本地存根发生异常");
            return "容错数据";
        }
    }
}
