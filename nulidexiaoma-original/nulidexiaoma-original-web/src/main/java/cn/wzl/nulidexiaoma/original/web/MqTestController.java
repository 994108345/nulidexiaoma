package cn.wzl.nulidexiaoma.original.web;/**
 * Created by wenzailong on 2018/7/4.
 */

import cn.wzl.nulidexiaoma.api.MqService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wenzailong
 * @create 2018-07-04 18:00
 **/
@Controller
@RequestMapping("MqTest")
public class MqTestController {
    @Resource
    MqService mqService;
    @RequestMapping(value = "sendMq" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo sendMq(@RequestBody  String mqStr){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo = mqService.sendTestMq(mqStr);
        return messageInfo;
    }
}
