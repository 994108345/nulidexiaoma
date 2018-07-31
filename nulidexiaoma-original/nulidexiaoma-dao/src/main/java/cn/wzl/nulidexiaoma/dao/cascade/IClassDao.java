package cn.wzl.nulidexiaoma.dao.cascade;

import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IClassDao extends IBaseToolsDao {

    /**
     * 一对多级联查询
     * @param id
     * @return
     */
    List<Class> getClassById(@Param("id") int id);

    /**
     * 一级缓存查询（默认开启一级缓存）
     * @param id
     * @return
     */
    List<Class> getClassByFirLevelCache(@Param("id") int id);

}