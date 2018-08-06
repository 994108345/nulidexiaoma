package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/8/3.
 */

import cn.wzl.nulidexiaoma.html.api.BarService;
import org.springframework.stereotype.Service;

/**
 * @author wenzailong
 * @create 2018-08-03 17:03
 **/
@Service
public class BarServiceImpl implements BarService {

    @Override
    public void genericInvoke() {
        System.out.println("你调我了吗");
    }
}
