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

    /**
     * 批量查询
     * @param o
     * @return
     */
    public List selectList(Object o);

    /**
     * 批量插入
     * @param list
     * @return
     */
    public int insertList(List list);

    /**
     * 批量更新
     * @param list
     * @return
     */
    public int updateList(List list);

    /**
     * 批量删除
     * @param list
     * @return
     */
    public int deleteList(List list);
}
