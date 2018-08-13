package cn.wzl.nulidexiaoma.original.dao.multithreading.impl;

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.original.dao.multithreading.IThreadTestDao;
import cn.wzl.nulidexiaoma.model.ThreadTest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wenzailong on 2018/3/11.
 */
@Repository
public class ThreadTestDaoImpl extends BaseToolsDaoImpl implements IThreadTestDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.original.dao.multithreading.IThreadTestDao.";
    }

    @Override
    public void updateThreadInfo(List<ThreadTest> list) {
        this.localSqlSession.update(getNameSpace()+"updateThreadInfo",list);
    }

    @Override
    public int updateOne(ThreadTest threadTest) {
        return localSqlSession.update(getNameSpace()+"updateOne",threadTest);
    }
}
