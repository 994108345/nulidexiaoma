package cn.wzl.nulidexiaoma.dao.cascade;

import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.FemaleStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IFemaleStudentDao extends IBaseToolsDao {
    /**
     * 根据学生id查
     * @param stuId
     * @return
     */
    List getFemaleStudentById(@Param("stuId") int stuId);

}