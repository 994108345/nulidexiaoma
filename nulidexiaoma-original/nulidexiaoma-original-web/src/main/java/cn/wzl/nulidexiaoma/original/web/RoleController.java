package cn.wzl.nulidexiaoma.original.web;

import cn.wzl.nulidexiaoma.api.IRoleService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.UUIdUtils;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.RolePageBean;
import cn.wzl.nulidexiaoma.model.Role;
import cn.wzl.nulidexiaoma.model.RoleUser;
import cn.wzl.nulidexiaoma.service.impl.bean.BranchBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wenzailong on 2018/1/8.
 */
@Controller
@RequestMapping("Role")
public class RoleController {
    @Resource
    IRoleService roleService;
    @RequestMapping(value = "getRolePageBean" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public SearchResult getRolePageBean(@RequestBody RolePageBean rolePageBean){
        SearchResult searchResult = new SearchResult();
        searchResult = roleService.getPageBean(rolePageBean);
        return searchResult;
    }
    @RequestMapping(value = "addRole" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST)
    @ResponseBody
    public MessageInfo addRole(@RequestBody Map map){
        MessageInfo messageInfo = new MessageInfo();
        List<BranchBean> branchList = (List)map.get("menu");
        if(branchList == null || branchList.size()<1){
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"权限菜单不能为空");
            return messageInfo;
        }
        Object object = map.get("role");
        if(object == null){
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"未接收到权限信息");
            return messageInfo;
        }
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(object));
        Role role = JSON.toJavaObject(jsonObject,Role.class);
        messageInfo = roleService.addOneRole(branchList,role);
        return messageInfo;
    }

    @RequestMapping(value = "deleteRole" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo deleteRole(@RequestBody RoleUser roleUser){
        return roleService.deleteRole(roleUser);
    }
}
