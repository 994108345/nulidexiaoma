package cn.wzl.nulidexiaoma.api;

import cn.wzl.nulidexiaoma.common.exception.JdbcException;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.RolePageBean;

import java.util.List;

/**
 * Created by wenzailong on 2018/1/8.
 */
public interface IRoleService {

    /**
     * 查询分页数据
     * @param rolePageBean
     * @return
     */
    public SearchResult getPageBean(RolePageBean rolePageBean);
}
