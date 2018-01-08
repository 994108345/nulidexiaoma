package cn.wzl.nulidexiaoma.web;

import cn.wzl.nulidexiaoma.api.IRoleService;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.RolePageBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by wenzailong on 2018/1/8.
 */
@Controller
@RequestMapping("Role")
public class RoleController {
    @Resource
    IRoleService roleService;
    @RequestMapping(value = "getRolePageBean" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST,consumes = "application/json")
    public SearchResult getRolePageBean(@RequestBody RolePageBean rolePageBean){
        return roleService.getPageBean(rolePageBean);
    }
}
