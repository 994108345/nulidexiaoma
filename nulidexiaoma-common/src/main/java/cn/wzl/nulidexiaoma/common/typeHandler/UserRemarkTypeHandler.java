package cn.wzl.nulidexiaoma.common.typeHandler;/**
 * Created by wenzailong on 2018/4/25.
 */

import cn.wzl.nulidexiaoma.common.enums.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wenzailong
 * @create 2018-04-25 14:36
 **/
@MappedTypes(String.class)
public class UserRemarkTypeHandler implements TypeHandler<String> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        String resultParam = "";
        if(parameter.equals("1")){
            resultParam = "备注为1";
        }else{
            resultParam = "备注不为1";
        }
        ps.setString(i,resultParam);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        String returnVal = rs.getString(columnName);
        if(returnVal=="备注为1"){
            return "1";
        }else{
            return "不为1";
        }
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        String returnVal = rs.getString(columnIndex);
        if(returnVal=="备注为1"){
            return "1";
        }else{
            return "不为1";
        }
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String returnVal = cs.getString(columnIndex);
        if(returnVal=="备注为1"){
            return "1";
        }else{
            return "不为1";
        }
    }
}
