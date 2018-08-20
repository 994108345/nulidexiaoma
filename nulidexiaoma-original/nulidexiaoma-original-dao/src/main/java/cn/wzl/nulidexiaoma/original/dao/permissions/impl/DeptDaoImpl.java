package cn.wzl.nulidexiaoma.original.dao.permissions.impl;/**
 * Created by wenzailong on 2018/8/16.
 */

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.model.Dept;
import cn.wzl.nulidexiaoma.original.dao.permissions.IDeptDao;

/**
 * @author wenzailong
 * @create 2018-08-16 17:47
 **/
public class DeptDaoImpl extends BaseToolsDaoImpl<Dept> implements IDeptDao{
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.original.dao.permissions.IDeptDao.";
    }

}
