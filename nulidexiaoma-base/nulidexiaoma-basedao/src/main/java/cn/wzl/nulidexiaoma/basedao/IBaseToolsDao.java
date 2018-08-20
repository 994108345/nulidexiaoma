package cn.wzl.nulidexiaoma.basedao;

import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;

import java.util.List;

/**
 * Created by 99410 on 2017/12/5.
 */
public interface IBaseToolsDao<T> {

    /**
     * 根据id查询一条记录
     * @return
     */
    T getById(Object id);

    /**
     * 根据id查询集合
     * @param id
     * @return
     */
    List<T> listById(Object id);





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
    public int insertListBatch(List list,String tableName);

    /**
     * 插入一条记录
     * @param object
     * @return
     */
    public int insertOne(Object object);

    /**
     * 批量更新
     * @param list
     * @return
     */
    public int updateListBatch(List list,String tableName);

    /**
     * 批量删除
     * @param list
     * @return
     */
    public int deleteList(List list);

    /**
     * 删除一条记录
     * @param object
     * @return
     */
    public int deleteOne(Object object);

    /**
     * 更新一条记录
     * @return
     */
    public int updateOne(Object object);



}
