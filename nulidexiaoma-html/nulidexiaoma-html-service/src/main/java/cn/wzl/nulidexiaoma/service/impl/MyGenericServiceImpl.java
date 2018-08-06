package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/8/3.
 */

import cn.wzl.nulidexiaoma.html.api.MyGenericService;
import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Service;

/**
 * @author wenzailong
 * @create 2018-08-03 16:58
 **/
@Service
public class MyGenericServiceImpl implements GenericService {

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        System.out.println("泛化了吗？");
        if("genericInvoke".equals(method)){
            return "weclome";
        }
        return null;
    }
}
