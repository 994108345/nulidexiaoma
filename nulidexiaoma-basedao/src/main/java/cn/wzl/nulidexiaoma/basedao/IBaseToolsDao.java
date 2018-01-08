package cn.wzl.nulidexiaoma.basedao;

import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;

import java.util.List;

/**
 * Created by 99410 on 2017/12/5.
 */
public interface IBaseToolsDao<T> {

    /**
     * 查询分页记录
     * @param t
     * @return
     */
    public List selectListByCondition(Object t);

    /**
     * 查询分页记录数
     * @param t
     * @return
     */
    public int selectCountByCondition(Object t);

    /**
     * 查询分页
     * @param o
     * @return
     */
    public SearchResult selectPageBean(Object o);
}
