package cn.wzl.nulidexiaoma.original.dao.cascade.impl;/**
 * Created by wenzailong on 2018/4/25.
 */

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.original.dao.cascade.IStudentDao;
import cn.wzl.nulidexiaoma.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wenzailong
 * @create 2018-04-25 17:01
 **/
@Repository
public class StudentDaoImpl extends BaseToolsDaoImpl implements IStudentDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.original.dao.cascade.IStudentDao.";
    }

    @Override
    public List<Student> getStudentById(@Param("id") int id) {
        return localSqlSession.selectList(getNameSpace()+ "getStudentById",id);
    }

    @Override
    public List<Student> getStudentByDiscriminator(int id) {
        return localSqlSession.selectList(getNameSpace() + "getStudentByDiscriminator",id);
    }
}
