package cn.wzl.nulidexiaoma.original.web;

import cn.wzl.nulidexiaoma.api.IRedisService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.annotation.Action;
import cn.wzl.nulidexiaoma.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenzailong on 2018/3/3.
 */
@Controller
@RequestMapping("UserRange")
public class UserRangeController {
    @Autowired
    IRedisService iRedisService;

    /**
     * 给列表添加信息
     * @param user
     * @return
     */
    @RequestMapping(value = "addUserToList" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    @Action(name = "缓存登录信息")
    public MessageInfo addUserToList(User user){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo = iRedisService.addListKey(user);
        return  messageInfo;
    }

    /**
     * 获取最近前十的登录信息
     * @return
     */
    @RequestMapping(value = "getTop10" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    @Action(name = "获取最近前十的登录信息")
    public MessageInfo getTop10(){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo = iRedisService.getListTop10();
        return  messageInfo;
    }
}
