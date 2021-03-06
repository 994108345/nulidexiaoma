package cn.wzl.nulidexiaoma.api;

import cn.wzl.nulidexiaoma.common.MessageInfo;

/**
 * Created by wenzailong on 2018/3/4.
 */
public interface IMultiThreadingService {
    /**
     * 传统循环遍历，处理数据
     * @return
     */
    MessageInfo<String> normalMathod();

    /**
     * 使用多线程处理
     * @param threadNum 线程数
     * @return
     */
    MessageInfo<String> threadMathod(int threadNum);

    /**
     * 返回几个随机数的和
     * @return
     */
    MessageInfo returnRandom();

    /**
     * 测试limit分批查询数据并处理的功能
     * @return
     */
    MessageInfo limitTest();


}
