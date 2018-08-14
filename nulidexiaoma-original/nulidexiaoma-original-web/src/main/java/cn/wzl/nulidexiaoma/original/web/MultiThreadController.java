package cn.wzl.nulidexiaoma.original.web;

import cn.wzl.nulidexiaoma.api.IMultiThreadingService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenzailong on 2018/3/4.
 */
@Controller
@RequestMapping("MultiThread")
public class MultiThreadController {
    @Autowired
    IMultiThreadingService iMultiThreadingService;

    @RequestMapping(value = "normalMethod" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo normalMethod(){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo = iMultiThreadingService.normalMathod();
        return  messageInfo;
    }

    @RequestMapping(value = "multiThreadMethod" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo multiThreadMethod(@RequestBody int num){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo = iMultiThreadingService.threadMathod(num);
        return  messageInfo;
    }
}
