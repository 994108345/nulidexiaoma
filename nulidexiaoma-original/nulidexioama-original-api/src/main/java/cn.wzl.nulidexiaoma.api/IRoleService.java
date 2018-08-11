package cn.wzl.nulidexiaoma.api;

import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.RolePageBean;
import cn.wzl.nulidexiaoma.model.Role;

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

    /**
     * 删除一条记录
     * @param role
     * @return
     */
    public MessageInfo deleteOne(Role role);

    /**
     * 更新一条记录
     * @return
     */
    public MessageInfo updateOne(Role role);

    /**
     * 批量插入
     * @param list
     * @return
     */
    public MessageInfo insertList(List list);
}
