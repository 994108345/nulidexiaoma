package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IRoleService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.UUIdUtils;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.RolePageBean;
import cn.wzl.nulidexiaoma.model.Menu;
import cn.wzl.nulidexiaoma.model.RoleMenu;
import cn.wzl.nulidexiaoma.model.RoleUser;
import cn.wzl.nulidexiaoma.original.dao.permissions.IMenuRoleDao;
import cn.wzl.nulidexiaoma.original.dao.permissions.IRoleDao;
import cn.wzl.nulidexiaoma.model.Role;
import cn.wzl.nulidexiaoma.original.dao.permissions.IRoleUserDao;
import cn.wzl.nulidexiaoma.service.impl.bean.BranchBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
                JSONObject jonsObject  =(JSONObject) JSON.toJSON(menu);
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
}
