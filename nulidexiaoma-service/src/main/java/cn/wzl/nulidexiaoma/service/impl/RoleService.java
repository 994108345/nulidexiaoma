package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IRoleService;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.exception.JdbcException;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.RolePageBean;
import cn.wzl.nulidexiaoma.dao.permissions.IRoleDao;
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
     * 查询角色表的分页数据
     * @param rolePageBean
     * @return
     */
    @Override
    public SearchResult selectPageBean(RolePageBean rolePageBean) {
        SearchResult messageInfo = new SearchResult();
        try {
            List list = roleService.selectListByCondition(rolePageBean);
            int totalRecords = roleService.selectCountByCondition(rolePageBean);
            messageInfo.setData(list);
            messageInfo.setTotalRecords(totalRecords);
        } catch (Exception e) {
            logger.error("查询分页-角色表出错：" + e.getMessage());
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"查询分页-角色表出错：" + e.getMessage());

        }
        return messageInfo;
    }

    /**
     * 查询分页记录
     * @param rolePageBean
     * @return
     * @throws JdbcException
     */
    @Override
    public List selectListByCondition(RolePageBean rolePageBean) throws JdbcException {
        try{
            return roleDao.selectListByCondition(rolePageBean);
        }catch(Exception e){
            throw new JdbcException("查询记录出错" + e.getMessage());
        }
    }

    /**
     * 查询记录总数
     * @param rolePageBean
     * @return
     * @throws JdbcException
     */
    @Override
    public int selectCountByCondition(RolePageBean rolePageBean) throws JdbcException{
        try{
            return roleDao.selectCountByCondition(rolePageBean);
        }catch(Exception e){
            throw new JdbcException("查询记录总数出错" + e.getMessage());
        }
    }

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
}
