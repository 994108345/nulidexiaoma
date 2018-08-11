package cn.wzl.nulidexiaoma.original.dao.cascade.impl;/**
 * Created by wenzailong on 2018/4/25.
 */

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.original.dao.cascade.IClassDao;
import cn.wzl.nulidexiaoma.model.Class;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wenzailong
 * @create 2018-04-25 17:00
 **/
@Repository
public class ClassDaoImpl extends BaseToolsDaoImpl implements IClassDao {
    @Override
    public String getNameSpace() {
        return "IClassDao.";
    }

    @Override
    public List<Class> getClassById(int id) {
        return localSqlSession.selectList(getNameSpace()+"getClassById",id);
    }

    @Override
    public List<Class> getClassByFirLevelCache(int id) {
        return localSqlSession.selectList(getNameSpace()+"getClassByFirLevelCache",id);
    }
}
