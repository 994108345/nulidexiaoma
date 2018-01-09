package cn.wzl.nulidexiaoma.web;

import cn.wzl.nulidexiaoma.api.IMenuService;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.MenuPageBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by wenzailong on 2018/1/9.
 */
@Controller
@RequestMapping("Menu")
public class MenuController {
    @Resource
    IMenuService iMenuService;

    @RequestMapping(value = "getMenuPageBean" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public SearchResult getPageBean(@RequestBody MenuPageBean menuPageBean){
        return iMenuService.getPageBean(menuPageBean);
    }
}
