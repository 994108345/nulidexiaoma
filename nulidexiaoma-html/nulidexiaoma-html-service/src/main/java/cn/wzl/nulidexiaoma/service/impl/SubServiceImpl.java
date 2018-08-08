package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/8/8.
 */

import cn.wzl.nulidexiaoma.html.api.SubService;
import org.springframework.stereotype.Service;

/**
 * @author wenzailong
 * @create 2018-08-08 13:13
 **/
@Service
public class SubServiceImpl implements SubService {


    public String sayHello(String name){
        System.out.println("我是SubServiceImpl");
     return "系统数据";
    }

}
