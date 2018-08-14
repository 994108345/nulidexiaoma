package cn.wzl.nulidexiaoma.original.web;/**
 * Created by wenzailong on 2018/6/13.
 */

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wenzailong
 * @create 2018-06-13 17:21
 **/
@Controller
@RequestMapping("JVM")
public class JVMTestContoller {
    @RequestMapping(value = "test1" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    public void jmvTest(){
        System.out.println("begin");
        for (int i = 0; i < 10; i++) {
            byte[] b = new byte[1024 * 1024 * 100];
        }
        System.out.println("end");
    }

}
