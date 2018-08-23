package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IRoleService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.UUIdUtils;
import cn.wzl.nulidexiaoma.common.exception.NulidexiaomaException;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.RolePageBean;
import cn.wzl.nulidexiaoma.model.Menu;
import cn.wzl.nulidexiaoma.model.RoleMenu;
import cn.wzl.nulidexiaoma.model.RoleUser;
import cn.wzl.nulidexiaoma.original.dao.permissions.IMenuDao;
import cn.wzl.nulidexiaoma.original.dao.permissions.IMenuRoleDao;
import cn.wzl.nulidexiaoma.original.dao.permissions.IRoleDao;
import cn.wzl.nulidexiaoma.model.Role;
import cn.wzl.nulidexiaoma.original.dao.permissions.IRoleUserDao;
import cn.wzl.nulidexiaoma.service.impl.bean.BranchBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenzailong on 2018/1/8.
 */
@Service("roleService")
public class RoleService implements IRoleService {
    private Logger logger = LoggerFactory.getLogger(RoleService.class);
    @Resource
    IRoleDao roleDao;
    @Resource
    IRoleService roleService;
    @Autowired
    private IMenuRoleDao menuRoleDao;
    @Autowired
    private IRoleUserDao roleUserDao;
    @Autowired
    private IMenuDao menuDao;


    /**
     * 查询分页数据
     * @param rolePageBean
     * @return
     */
    @Override
    public SearchResult getPageBean(RolePageBean rolePageBean) {
        SearchResult searchResult = roleDao.selectPageBean(rolePageBean);
        return searchResult;
    }

    @Override
    public MessageInfo deleteOne(Role role) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            int returnNUm = roleDao.deleteOne(role);
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"删除角色出错"+e.getMessage());
        }
        return messageInfo;
    }

    @Override
    public MessageInfo updateOne(Role role) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            int returnNUm = roleDao.updateOne(role);
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"删除角色出错"+e.getMessage());
        }
        return messageInfo;
    }

    @Override
    public MessageInfo insertList(List list) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            int returnNUm = roleDao.insertListBatch(list,"insertList");
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"删除角色出错"+e.getMessage());
        }
        return messageInfo;
    }

    @Override
    public MessageInfo addOneRole(List menus, Role role) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            /*获取一个uuid，当做role 的roleId*/
            String uuid = UUIdUtils.getOneUUId();
            role.setRoleId(uuid);
            List<RoleMenu> roleMenuList = new ArrayList<>();
            for (Object menu : menus) {

                JSONObject jonsObject = JSON.parseObject(menu.toString());
                BranchBean branchBean = jonsObject.toJavaObject(BranchBean.class);
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setMenuId(branchBean.getData());
                roleMenu.setRoleId(uuid);
                roleMenuList.add(roleMenu);
            }
            roleService.addRoleTrans(roleMenuList,role);
        } catch (Exception e) {
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"新增角色出错"+e.getMessage());
            logger.error("新增角色出错"+e.getMessage(),e);
        }

        return messageInfo;
    }

    @Override
    @Transactional
    public void addRoleTrans(List roleMenuList, Role role) {
        roleDao.insertOne(role);
            /*插入角色菜单表*/
        menuRoleDao.insertListBatch(roleMenuList,"insertListBatch");
    }

    @Override
    public MessageInfo deleteRole(RoleUser roleUser) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            List<RoleUser> roleUserList = roleUserDao.listRoleUserBycondition(roleUser);
            if(roleUserList.size()>0){
                messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"该角色还存在引用关系，请清除用户对该角色的引用");
            }else{
                Role role = new Role();
                role.setRoleId(roleUser.getRoleId());
                roleDao.deleteOne(role);
            }
        } catch (Exception e) {
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"删除增角色出错"+e.getMessage());
            logger.error("删除角色出错"+e.getMessage(),e);
        }
        return messageInfo;
    }

    @Override
    public MessageInfo beginEditRole(Role role) {
        MessageInfo messageInfo = new MessageInfo();
        Map<String,Menu> menuMap = new HashMap<>();
        try {
            List<Menu> menuList = roleDao.listMenuByRoleId(role);
            if(menuList.size()>0){
                for (Menu menu : menuList) {
                    menuMap.put(menu.getMenuId(),menu);
                }
                List<Menu> originalMenuList =menuDao.selectList(new Menu());
                List resuleList = getMenuTree(originalMenuList,"0",originalMenuList.size(),menuMap);
                messageInfo.setData(resuleList);
            }
        } catch (Exception e) {
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"获取菜单出错"+e.getMessage());
            logger.error("获取菜单出错"+e.getMessage(),e);
        }
        return messageInfo;
    }
    /**
     * 递归菜单(将已经拥有的菜单设置为已选状态)
     * @param menuList 数据源，即需要递归的数组
     * @param menuId 父菜单的id
     * @param n 递归的次数
     * @return
     */
    public List getMenuTree(List<Menu> menuList,String menuId,int n,Map<String,Menu> map){
        List<BranchBean> resultList = new ArrayList();

        List<BranchBean> children = new ArrayList();
        for(Menu menu:menuList){
            String parentId = menu.getParentId()+"";
            if(StringUtils.equals(parentId,menuId)){
                String id = menu.getMenuId();
                Menu menu1 = map.get(id);
                BranchBean branch = new BranchBean();
                if(menu1 != null){
                    branch.setPartialSelected(true);
                }else{
                    branch.setPartialSelected(false);
                }
                branch.setSelectable(true);
                branch.setLabel(menu.getMenuName());
                branch.setData(menu.getMenuId());
                branch.setMenu(menu);
                branch.setExpanded(true);
                resultList.add(branch);
            }
        }
        for(BranchBean child:resultList){
            child.setChildren(getMenuTree(menuList,child.getData(),n-1,map));
        }
        if(n == 0){
            return resultList;
        }
        return resultList;
    }

    @Override
    public MessageInfo saveOneRole(Map<String, Object> paramMap) {
        MessageInfo messageInfo  = new MessageInfo();
        List<RoleMenu> menuList = new ArrayList<>();
        try {
            Object roleObj = paramMap.get("role");
            if(roleObj == null){
                throw new NulidexiaomaException("请求参数缺少角色信息");
            }
            List<Object> paramList = (List<Object>) paramMap.get("menuList");
            if(paramList == null){
                throw new NulidexiaomaException("请求参数缺少菜单信息");
            }
            Role role = JSON.toJavaObject(JSON.parseObject(JSON.toJSONString(roleObj)),Role.class);
            for (Object o : paramList) {
                RoleMenu roleMenu = JSON.toJavaObject(JSON.parseObject(JSON.toJSONString(o)),RoleMenu.class);
                roleMenu.setRoleId(role.getRoleId());
                menuList.add(roleMenu);
            }
            saveOneRoleByTransaction(role,menuList);
        } catch (Exception e) {
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"更新角色出错"+e.getMessage());
            logger.error("更新角色出错"+e.getMessage(),e);
        }
        return messageInfo;
    }

    @Override
    public void saveOneRoleByTransaction(Role role, List<RoleMenu> menuList) {
        /*更新角色*/
        roleDao.updateOne(role);
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(roleMenu.getRoleId());
        /*删除旧的角色菜单*/
        menuRoleDao.deleteRoleMenuByRoleId(roleMenu);
        /*插入新的角色菜单*/
        menuRoleDao.insertListBatch(menuList,"insertListBatch");
    }

    @Override
    public MessageInfo getOneRole(Role role) {
        MessageInfo messageInfo = new MessageInfo();
        try {
            Role returnRole = roleDao.getById(role);
            if(returnRole == null){
                throw new NulidexiaomaException("查询不到角色信息");
            }
            messageInfo.setData(returnRole);
        } catch (Exception e) {
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"查询角色出错"+e.getMessage());
            logger.error("查询角色出错"+e.getMessage(),e);
        }
        return messageInfo;
    }
}
