package cn.wzl.nulidexiaoma.dao.multithreading;


import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.MultiThreading;

import java.util.List;

public interface IMultiThreadingDao extends IBaseToolsDao {
    /**
     * 查询所有的记录
     * @return
     */
    List<MultiThreading> selectAllDate();

    /**
     * 更新所有的记录
     * @param list
     * @return
     */
    int updateMultiThreading(List<MultiThreading> list);
}