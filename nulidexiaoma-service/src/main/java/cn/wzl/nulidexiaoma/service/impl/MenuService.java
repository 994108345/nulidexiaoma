package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IMenuService;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.MenuPageBean;
import cn.wzl.nulidexiaoma.dao.permissions.IMenuDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wenzailong on 2018/1/9.
 */
@Service("menuService")
public class MenuService implements IMenuService{
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
}
