package cn.wzl.nulidexiaoma.web;

import cn.wzl.nulidexiaoma.api.IMenuService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.MenuPageBean;
import cn.wzl.nulidexiaoma.model.Menu;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzailong on 2018/1/9.
 */
@Controller
@RequestMapping("Menu")
public class MenuController {
    @Resource
    IMenuService iMenuService;

    /**
     * 获取分页信息
     * @param menuPageBean
     * @return
     */
    @RequestMapping(value = "getMenuPageBean" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public SearchResult getPageBean(@RequestBody MenuPageBean menuPageBean){
        return iMenuService.getPageBean(menuPageBean);
    }

    /**
     * 获取菜单集合
     * @param menu
     * @return
     */
    @RequestMapping(value = "getMenuList" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo getMenuList(@RequestBody Menu menu){
        return iMenuService.selectList(menu);
    }

    /**
     * 获取树形菜单集合
     * @return
     */
    @RequestMapping(value = "getMenuTree" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo getMenuTree(Menu menu){
        return iMenuService.selectAllList(menu);
    }

    /**
     * 获取菜单
     * @param menu
     * @return
     */
    @RequestMapping(value = "addMenu" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo addMenu(@RequestBody Menu menu){
        List list = new ArrayList<>();
        list.add(menu);
        return iMenuService.insertList(list);
    }

    /**
     * 删除菜单
     * @param menu
     * @return
     */
    @RequestMapping(value = "deleteMenu" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo deleteMenu(@RequestBody Menu menu){
        return iMenuService.deleteOne(menu);
    }

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    @RequestMapping(value = "updateMenu" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public MessageInfo updateMenu(@RequestBody Menu menu){
        return iMenuService.updateOne(menu);
    }
}
