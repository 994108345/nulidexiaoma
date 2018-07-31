package cn.wzl.nulidexiaoma.dao.multithreading.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.dao.multithreading.IMultiThreadingDao;
import cn.wzl.nulidexiaoma.model.MultiThreading;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wenzailong on 2018/3/4.
 */
@Repository
public class MultiThreadingImpl extends BaseToolsDaoImpl implements IMultiThreadingDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.multithreading.IMultiThreadingDao.";
    }

    @Override
    public List<MultiThreading> selectAllDate() {
        return localSqlSession.selectList(getNameSpace()+"selectAllDate");
    }

    @Override
    public int updateMultiThreading(List<MultiThreading> multThreadList) {
        return this.updateListBatch(multThreadList,"updateMultiThreading");
    }

    @Override
    public List<MultiThreading> listMultiThreadByLimit(int begin, int countNum) {
        return null;
    }
}
