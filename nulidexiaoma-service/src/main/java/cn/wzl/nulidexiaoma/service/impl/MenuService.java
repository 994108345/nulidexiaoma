package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IMenuService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.MenuPageBean;
import cn.wzl.nulidexiaoma.dao.permissions.IMenuDao;
import cn.wzl.nulidexiaoma.model.Menu;
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
            for(int i = 0; i < list.size(); i++){

            }
            messageInfo.setData(list);
        } catch (Exception e) {
            logger.error("查找树形菜单出错" + e.getMessage());
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"查找树形菜单出错");
        }
        return messageInfo;
    }
}
