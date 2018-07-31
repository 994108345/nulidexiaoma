package cn.wzl.nulidexiaoma.dao.cascade.impl;/**
 * Created by wenzailong on 2018/4/26.
 */

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.dao.cascade.IClassDao;
import cn.wzl.nulidexiaoma.dao.cascade.IFemaleStudentDao;

import java.util.List;

/**
 * @author wenzailong
 * @create 2018-04-26 10:26
 **/
public class FemaleStudentDaoImpl extends BaseToolsDaoImpl implements IFemaleStudentDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.cascade.IFemaleStudentDao.";
    }

    @Override
    public List getFemaleStudentById(int stuId) {
        return localSqlSession.selectList(getNameSpace()+"getFemaleStudentById",stuId);
    }
}
