package cn.wzl.nulidexiaoma.web;

import cn.wzl.nulidexiaoma.api.ILoginService;
import cn.wzl.nulidexiaoma.common.Exception.LoginException;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.model.User;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * Created by wenzailong on 2017/12/14.
 */
@Controller
@RequestMapping("Login")
public class LoginController {
    @Resource
    ILoginService loginService;

    @RequestMapping(value = "login" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo login(@RequestBody User user){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo = loginService.selectUser(user);
        return messageInfo;
    }
}
