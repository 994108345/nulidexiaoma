package cn.wzl.nulidexiaoma.basedao.impl;

import cn.wzl.nulidexiaoma.basedao.IBaseToolsDao;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.common.exception.JdbcException;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 99410 on 2017/12/5.
 */
@Repository
public abstract class BaseToolsDaoImpl<T> implements IBaseToolsDao<T>{
    /*设置dao命名空间*/
    public abstract String getNameSpace();

    @Resource
    protected SqlSessionTemplate localSqlSession;

    /**
     * 查询数据
     * @param object
     * @return
     */
    public List selectListByCondition(Object object){
        return localSqlSession.selectList(getNameSpace()+"selectListByCondition",object);
    }

    /**
     * 查询分页总记录数
     * @param object
     * @return
     */
    @Override
    public int selectCountByCondition(Object object) {
        return localSqlSession.selectOne(getNameSpace()+"selectCountByCondition",object);
    }
    /**
     * 查询分页数据
     * @param o
     * @return
     */
    @Override
    public SearchResult selectPageBean(Object o) {
        SearchResult messageInfo = new SearchResult();
        try {
            int totalRecords = this.selectCountByCondition(o);
            List list = this.selectListByCondition(o);
            messageInfo.setData(list);
            messageInfo.setTotalRecords(totalRecords);
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"查询分页出错：" + e.getMessage());

        }
        return messageInfo;
    }

    /**
     * 批量查询
     * @param o
     * @return
     */
    @Override
    public List selectList(Object o) {
        return localSqlSession.selectList(getNameSpace()+"selectList",o);
    }

    /**
     * 批量插入
     * @param list
     * @return
     */
    @Override
    public int insertList(List list) {
        if(list.size()<=1000){
            return localSqlSession.insert(getNameSpace()+"insertList",list);
        }else{
            List insertList = new ArrayList();
            for(int i =0; i < list.size();){
                if(i+1000<list.size()) {
                    insertList = list.subList(i, 1000);
                }else{
                    insertList = list.subList(i, list.size());
                }
                i = i + 1000;
                localSqlSession.insert(getNameSpace()+"insertList",insertList);
            }
        }
        return 0;
    }

    /**
     * 批量更新
     * @param list
     * @return
     */
    @Override
    public int updateList(List list) {
        if(list.size()<=1000){
            return localSqlSession.update(getNameSpace()+"updateList",list);
        }else{
            List insertList = new ArrayList();
            for(int i =0; i < list.size();){
                if(i+1000<list.size()) {
                    insertList = list.subList(i, 1000);
                }else{
                    insertList = list.subList(i, list.size());
                }
                i = i + 1000;
                localSqlSession.update(getNameSpace()+"updateList",insertList);
            }
        }
        return 0;
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    @Override
    public int deleteList(List list) {
        if(list.size()<=1000){
            return localSqlSession.delete(getNameSpace()+"deleteList",list);
        }else{
            List insertList = new ArrayList();
            for(int i =0; i < list.size();){
                if(i+1000<list.size()) {
                    insertList = list.subList(i, 1000);
                }else{
                    insertList = list.subList(i, list.size());
                }
                i = i + 1000;
                localSqlSession.delete(getNameSpace()+"deleteList",insertList);
            }
        }
        return 0;
    }
}
