package cn.wzl.nulidexiaoma.dao.cascade;

import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.MaleStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMaleStudentDao extends IBaseToolsDao {
    /**
     * 根据学号id查
     * @param stuId
     * @return
     */
    List getMaleStudentById(@Param("stuId") int stuId);
}