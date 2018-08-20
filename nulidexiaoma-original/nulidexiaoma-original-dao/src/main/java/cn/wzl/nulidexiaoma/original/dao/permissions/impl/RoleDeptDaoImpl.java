package cn.wzl.nulidexiaoma.original.dao.permissions.impl;/**
 * Created by wenzailong on 2018/8/16.
 */

import cn.wzl.nulidexiaoma.basedao.impl.BaseToolsDaoImpl;
import cn.wzl.nulidexiaoma.model.RoleDept;
import cn.wzl.nulidexiaoma.original.dao.permissions.IRoleDeptDao;

/**
 * @author wenzailong
 * @create 2018-08-16 18:02
 **/
public class RoleDeptDaoImpl extends BaseToolsDaoImpl<RoleDept> implements IRoleDeptDao {
    @Override
    public String getNameSpace() {
        return "cn.wzl.nulidexiaoma.original.dao.permissions.IRoleDeptDao.";
    }
}
