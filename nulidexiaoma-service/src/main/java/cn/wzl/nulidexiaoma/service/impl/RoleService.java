package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IRoleService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.exception.JdbcException;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.RolePageBean;
import cn.wzl.nulidexiaoma.dao.permissions.IRoleDao;
import cn.wzl.nulidexiaoma.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
            int returnNUm = roleDao.insertList(list);
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"删除角色出错"+e.getMessage());
        }
        return messageInfo;
    }
}
