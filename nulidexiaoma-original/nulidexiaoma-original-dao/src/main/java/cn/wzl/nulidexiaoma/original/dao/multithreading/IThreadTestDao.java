package cn.wzl.nulidexiaoma.original.dao.multithreading;

import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.ThreadTest;

import java.util.List;

/**
 * Created by wenzailong on 2018/3/11.
 */
public interface IThreadTestDao extends IBaseToolsDao {
    void updateThreadInfo(List<ThreadTest> list);

    int updateOne(ThreadTest threadTest);

}
