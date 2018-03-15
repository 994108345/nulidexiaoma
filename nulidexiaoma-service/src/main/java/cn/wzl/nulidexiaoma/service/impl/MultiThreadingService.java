package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IMultiThreadingService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.dao.multithreading.IMultiThreadingDao;
import cn.wzl.nulidexiaoma.model.MultiThreading;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wenzailong on 2018/3/4.
 */
@Service("iMultiThreading")
public class MultiThreadingService implements IMultiThreadingService{
    int i = 0;
    int size = 0;
    List <MultiThreading> resultList = new ArrayList<>();
    List<MultiThreading> list = new ArrayList();

    @Autowired
    IMultiThreadingDao multiThreadingDao;

    @Override
    public MessageInfo<String> normalMathod() {
        MessageInfo<String> messageInfo = new MessageInfo<String>();
        List<MultiThreading> dataList = new ArrayList();
        List<MultiThreading> updateList = new ArrayList();

        try {
            dataList = multiThreadingDao.selectAllDate();

            long beginDate = System.currentTimeMillis();
            int i = 1;
            for (MultiThreading multiThreading : dataList) {
                multiThreading.setControlNum("处理过:"+i);
                i++;
                updateList.add(multiThreading);
            }
            multiThreadingDao.updateMultiThreading(updateList);
            long endDate = System.currentTimeMillis();
            long resultDate = endDate - beginDate;
            messageInfo.setData(resultDate+"");
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"普通方法处理数据出错" + e.getMessage());
        }
        return  messageInfo;
    }

    @Override
    public MessageInfo<String> threadMathod(int threadNum) {
        MessageInfo<String> messageInfo = new MessageInfo<String>();
        try {
            long beginDate = System.currentTimeMillis();
            MultiThreadingService multiThreadingService = new MultiThreadingService();
            multiThreadingService.list = multiThreadingDao.selectAllDate();
            multiThreadingService.size = this.list.size();
            ExecutorService exec = Executors.newSingleThreadExecutor ();
            System.out.println("准备进入:");
            for (int i = 0; i < 5; i++) {
                exec.execute(new MultiThread(multiThreadingService));
                System.out.println("启动线程:"+i);
            }
           exec.shutdown();
            System.out.println("线程全部结束了吗");
            if(CollectionUtils.isEmpty(resultList)){
                messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"插入集合为空");
                return messageInfo;
            }
            multiThreadingDao.updateMultiThreading(resultList);
            long endDate = System.currentTimeMillis();
            long resultDate = endDate - beginDate;
            messageInfo.setData(resultDate+"");
        }catch(Exception e){
            e.printStackTrace();

        }
        return  messageInfo;
    }

    public void multiThread(MultiThreadingService multiThreadingService){
        int i = multiThreadingService.i;
        int size = multiThreadingService.size;
        List<MultiThreading> list = multiThreadingService.list;
        System.out.println("看i" + i);
        while(i< 10) {
            System.out.println("进入了run........" + i);
            MultiThreading multiThreading = list.get(i);
            multiThreading.setControlNum("多线程：" + i);
            i++;
            resultList.add(multiThreading);
        }
    }

    /**
     * 内部类
     */
    class MultiThread implements Runnable{
        MultiThreadingService multiThreadingService;
        public MultiThread(MultiThreadingService multiThreadingService) {
            this.multiThreadingService = multiThreadingService;
        }

        @Override
        public void run() {
            multiThreadingService.multiThread(multiThreadingService);
        }
    }
}
