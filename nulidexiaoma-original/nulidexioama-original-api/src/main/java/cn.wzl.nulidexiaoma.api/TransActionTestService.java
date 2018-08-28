package cn.wzl.nulidexiaoma.api;

/**
 * Created by 99410 on 2018/8/27.
 */
public interface TransActionTestService {
    /**
     * required
     */
    void insertOne();

    /**
     * required
     */
    void addOne();

    /**
     * support
     */
    void insertBySupported();

    /**
     * support
     */
    void addSupported();

    /**
     * Mandatory
     */
    void insertByMandatory();

    /**
     * Mandatory
     */
    void addMandatory();


}
