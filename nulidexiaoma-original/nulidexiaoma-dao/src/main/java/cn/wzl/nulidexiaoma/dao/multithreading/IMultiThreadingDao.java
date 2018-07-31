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

    /**
     * 根据limit条件查询多线程表记录
     * @param begin
     * @param countNum
     * @return
     */
    List<MultiThreading> listMultiThreadByLimit(int begin,int countNum);
}