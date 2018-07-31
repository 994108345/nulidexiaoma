package cn.wzl.nulidexiaoma.dao.cascade.impl;/**
 * Created by wenzailong on 2018/4/25.
 */

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.dao.cascade.IStuCardDao;
import cn.wzl.nulidexiaoma.dao.cascade.IStudentDao;
import cn.wzl.nulidexiaoma.model.StuCard;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wenzailong
 * @create 2018-04-25 17:26
 **/
@Repository
public class StuCardDaoImpl extends BaseToolsDaoImpl implements IStuCardDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.dao.cascade.IStuCardDao.";
    }

    @Override
    public List<StuCard> getStuCardById(int id) {
        return localSqlSession.selectList(getNameSpace() +"getStuCardById",id);
    }
}
