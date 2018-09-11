package cn.wzl.nulidexiaoma.common.mongodb;/**
 * Created by wenzailong on 2018/7/2.
 */

import cn.wzl.nulidexiaoma.common.exception.NulidexiaomaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wenzailong
 * @create 2018-07-02 15:00
 **/
@Component
public class MongoDBUtils {
    private static final Logger logger = LoggerFactory.getLogger(MongoDBUtils.class);
    @Autowired
    private static MongoTemplate mongoTemplate;
    @Resource(name = "mongoTemplate")
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        MongoDBUtils.mongoTemplate = mongoTemplate;
    }

    /*根据集合名存数据*/
    public static void insertOneWithCollectionName(Object o,String collectionName) throws NulidexiaomaException {
        try{
            mongoTemplate.insert(o,collectionName);
        }catch (Exception e){
            logger.error("mongoDB:插入数据报错",e);
            throw new NulidexiaomaException("mongoDB:插入数据报错" + e.getMessage());
        }
    }

    /*自动根据对象类型创建集合并存数据*/
    public static void insertOne(Object o) throws NulidexiaomaException {
        try{
            mongoTemplate.insert(o);
        }catch (Exception e){
            logger.error("mongoDB:插入数据报错",e);
            throw new NulidexiaomaException("mongoDB:插入数据报错" + e.getMessage());
        }
    }

    /**
     * 查询记录
     * @param
     * @param tClass
     * @throws NulidexiaomaException
     */
    public static Object findOne(String keyName,String keyValue,Class tClass) throws NulidexiaomaException {
        try{
            Query query = new Query(Criteria.where(keyName).is(keyValue));
            return mongoTemplate.findOne(query,tClass);
        }catch (Exception e){
            logger.error("mongoDB:查询数据报错",e);
            throw new NulidexiaomaException("mongoDB:查询数据报错" + e.getMessage());
        }
    }
}
