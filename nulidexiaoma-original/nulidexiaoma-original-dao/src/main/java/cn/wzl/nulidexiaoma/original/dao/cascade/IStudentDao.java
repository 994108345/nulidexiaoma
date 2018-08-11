package cn.wzl.nulidexiaoma.original.dao.cascade;

import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.Student;
import com.alibaba.dubbo.config.support.Parameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentDao extends IBaseToolsDao {
    List<Student> getStudentById(@Param("id") int id);

    /**
     * 查询（鉴别器级联）
     * @param id
     * @return
     */
    List<Student> getStudentByDiscriminator(@Param("id") int id);

}