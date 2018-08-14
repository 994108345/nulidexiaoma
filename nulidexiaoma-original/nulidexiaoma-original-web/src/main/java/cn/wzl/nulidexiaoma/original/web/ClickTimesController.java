package cn.wzl.nulidexiaoma.original.web;/**
 * Created by wenzailong on 2018/8/13.
 */

import cn.wzl.nulidexiaoma.api.IRedisService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wenzailong
 * @create 2018-08-13 14:23
 **/
@Controller
@RequestMapping("ClickTimes")
public class ClickTimesController {
    @Autowired
    private IRedisService redisService;

    @RequestMapping("getClickTimes")
    @ResponseBody
    public MessageInfo getClickTimes(){
        MessageInfo addMessageInfo = redisService.addClickTimes();
        if(addMessageInfo.isSuccess()){
          MessageInfo getMessageInfo =  redisService.getClickTimes();
          return getMessageInfo;
        }else{
            return addMessageInfo;
        }

    }
}
