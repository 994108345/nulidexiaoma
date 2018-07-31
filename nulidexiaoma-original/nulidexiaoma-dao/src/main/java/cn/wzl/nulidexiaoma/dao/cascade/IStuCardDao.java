package cn.wzl.nulidexiaoma.dao.cascade;

import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.model.StuCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStuCardDao extends IBaseToolsDao {
    List<StuCard> getStuCardById(@Param("id") int id);
}