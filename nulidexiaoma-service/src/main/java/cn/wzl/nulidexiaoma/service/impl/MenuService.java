package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IMenuService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.MenuPageBean;
import cn.wzl.nulidexiaoma.dao.permissions.IMenuDao;
import cn.wzl.nulidexiaoma.model.Menu;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzailong on 2018/1/9.
 */
@Service("menuService")
public class MenuService implements IMenuService{

    private Logger logger = LoggerFactory.getLogger(MenuService.class);
    @Resource
    IMenuDao iMenuDao;


    /**
     * 查询分页数据
     * @param menuPageBean
     * @return
     */
    @Override
    public SearchResult getPageBean(MenuPageBean menuPageBean) {
        return iMenuDao.selectPageBean(menuPageBean);
    }

    /**
     * 批量查询菜单
     * @param menu
     * @return
     */
    @Override
    public MessageInfo selectList(Menu menu) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            List list = iMenuDao.selectList(menu);
            messageInfo.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"查询菜单信息出错");
        }
        return messageInfo;
    }

    /**
     * 查找所有菜单
     * @param menu
     * @return
     */
    @Override
    public MessageInfo selectAllList(Menu menu) {
        MessageInfo messageInfo = new MessageInfo();
        List resultList = new ArrayList();
        try {
            List list = iMenuDao.selectList(menu);
            List menuTreeList = this.getMenuTree(list,"0",list.size());
            messageInfo.setData(menuTreeList);
        } catch (Exception e) {
            logger.error("查找树形菜单出错" + e.getMessage());
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"查找树形菜单出错");
        }
        return messageInfo;
    }

    /**
     * 递归菜单
     * @return
     */
    public List getMenuTree(List<Menu> menuList,String menuId,int n){
        List<Branch> resultList = new ArrayList();

        List<Branch> children = new ArrayList();
        for(Menu menu:menuList){
            String parentId = menu.getParentId()+"";
            if(StringUtils.equals(parentId,menuId)){
                Branch branch = new Branch();
                Data data = new Data();
                data.menuId = menu.getMenuId();
                data.menuName = menu.getMenuName();
                branch.data = data;
                resultList.add(branch);
            }

        }
        for(Branch child:resultList){
            child.children = getMenuTree(menuList,child.data.menuId,n-1);
        }
        if(n == 0){
            return resultList;
        }
        return resultList;
    }

    /**
     * 批量插入菜单
     * @param list
     * @return
     */
    @Override
    public MessageInfo insertList(List list) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            int returnNum = iMenuDao.insertList(list);
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"插入菜单出错"+e.getMessage());
        }
        return messageInfo;
    }

    /**
     * 删除单条记录
     * @param menu
     * @return
     */
    @Override
    public MessageInfo deleteOne(Menu menu) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            int returnNum = iMenuDao.deleteOne(menu);
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"删除菜单发生异常"+e.getMessage());
        }
        return messageInfo;
    }

    /**
     * 更新一条菜单
     * @param menu
     * @return
     */
    @Override
    public MessageInfo updateOne(Menu menu) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            int returnNum = iMenuDao.updateOne(menu);
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"更新菜单发生异常"+e.getMessage());
        }
        return messageInfo;
    }
}
class Branch{
 public Data data;
 public List<Branch> children = new ArrayList();
}
class Data{
    public String menuName;
    public String menuId;

}
