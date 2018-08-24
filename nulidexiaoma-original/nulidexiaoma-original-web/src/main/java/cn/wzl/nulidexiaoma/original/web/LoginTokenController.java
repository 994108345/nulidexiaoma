package cn.wzl.nulidexiaoma.original.web;

import cn.wzl.nulidexiaoma.api.LoginTokenService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.annotation.Action;
import cn.wzl.nulidexiaoma.model.LoginToken;
import cn.wzl.nulidexiaoma.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 99410 on 2018/8/23.
 */
@Controller
@RequestMapping("Token")
public class LoginTokenController {
    @Autowired
    private LoginTokenService loginTokenService;
    @RequestMapping(value = "login" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo login(@RequestBody LoginToken loginToken){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo = loginTokenService.login(loginToken);
        return messageInfo;
    }

    @RequestMapping(value = "logOut" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo logOut(@RequestBody LoginToken loginToken){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo = loginTokenService.logOut(loginToken);
        return messageInfo;
    }
}
