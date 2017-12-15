package cn.wzl.nulidexiaoma.basedao.impl;

import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

/**
 * Created by 99410 on 2017/12/5.
 */
public abstract class BaseToolsDaoImpl implements IBaseToolsDao{
    /*设置dao命名空间*/
    public abstract String getNameSpace();

    @Resource
    protected SqlSessionTemplate localSqlSession;

}
