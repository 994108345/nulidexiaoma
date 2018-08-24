package cn.wzl.nulidexiaoma.original;

import cn.wzl.nulidexiaoma.original.LoginToken;

public interface LoginTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginToken record);

    int insertSelective(LoginToken record);

    LoginToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginToken record);

    int updateByPrimaryKey(LoginToken record);
}