package cn.wzl.nulidexiaoma.original.dao.cascade.impl;/**
 * Created by wenzailong on 2018/4/26.
 */

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.original.dao.cascade.IMaleStudentDao;

import java.util.List;

/**
 * @author wenzailong
 * @create 2018-04-26 10:26
 **/
public class MaleStudnetImpl extends BaseToolsDaoImpl implements IMaleStudentDao {
    @Override
    public String getNameSpace() {
        return "IMaleStudentDao.";
    }

    @Override
    public List getMaleStudentById(int stuId) {
        return localSqlSession.selectList(getNameSpace()+"getMaleStudentById",stuId);
    }
}
