package cn.wzl.nulidexiaoma.html.api;/**
 * Created by wenzailong on 2018/8/3.
 */

import com.alibaba.dubbo.rpc.service.GenericException;

/**
 * @author wenzailong
 * @create 2018-08-03 17:41
 **/
public interface MyGenericService {
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException;
}
